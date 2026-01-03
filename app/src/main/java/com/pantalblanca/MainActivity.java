package com.pantalblanca;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.provider.Settings;

public class MainActivity extends Activity {
    
    private View whiteScreen;
    private LinearLayout controlPanel;
    private boolean controlsVisible = false;
    private float originalBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Referencias a las vistas
        whiteScreen = findViewById(R.id.whiteScreen);
        controlPanel = findViewById(R.id.controlPanel);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnToggleBrightness = findViewById(R.id.btnToggleBrightness);
        Button btnHideControls = findViewById(R.id.btnHideControls);
        
        // Guardar brillo original
        try {
            originalBrightness = Settings.System.getInt(
                getContentResolver(), 
                Settings.System.SCREEN_BRIGHTNESS
            ) / 255.0f;
        } catch (Settings.SettingNotFoundException e) {
            originalBrightness = 0.5f;
        }
        
        // Configurar pantalla completa y brillo máximo
        setupFullscreen();
        setMaxBrightness();
        keepScreenOn();
        
        // Ocultar controles inicialmente
        controlPanel.setVisibility(View.GONE);
        
        // Click en pantalla blanca para mostrar/ocultar controles
        whiteScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleControls();
            }
        });
        
        // Botón salir
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        // Botón alternar brillo
        btnToggleBrightness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBrightness();
            }
        });
        
        // Botón ocultar controles
        btnHideControls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideControls();
            }
        });
    }
    
    private void setupFullscreen() {
        // Modo pantalla completa inmersivo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        
        // Ocultar barra de navegación
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }
    
    private void setMaxBrightness() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 1.0f; // Máximo brillo (1.0 = 100%)
        getWindow().setAttributes(layoutParams);
    }
    
    private void setNormalBrightness() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = originalBrightness;
        getWindow().setAttributes(layoutParams);
    }
    
    private void keepScreenOn() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    
    private void toggleControls() {
        if (controlsVisible) {
            hideControls();
        } else {
            showControls();
        }
    }
    
    private void showControls() {
        controlPanel.setVisibility(View.VISIBLE);
        controlsVisible = true;
    }
    
    private void hideControls() {
        controlPanel.setVisibility(View.GONE);
        controlsVisible = false;
    }
    
    private void toggleBrightness() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        if (layoutParams.screenBrightness >= 0.99f) {
            setNormalBrightness();
            Toast.makeText(this, "Brillo normal", Toast.LENGTH_SHORT).show();
        } else {
            setMaxBrightness();
            Toast.makeText(this, "Brillo máximo", Toast.LENGTH_SHORT).show();
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Restaurar brillo original al salir
        setNormalBrightness();
    }
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            setupFullscreen();
        }
    }
}
