# 🚀 GUÍA RÁPIDA - Pantalla Blanca APK

## ¿Qué es esto?

Una app Android que pone tu pantalla completamente en blanco con el brillo al máximo.
Perfecta para usar como linterna o luz de ambiente.

## 📥 Instalación Rápida (3 minutos)

### Método 1: Con Android Studio (Recomendado)

1. **Descarga Android Studio** → https://developer.android.com/studio
2. **Descomprime** el archivo `WhiteScreenApp.zip`
3. **Abre** la carpeta en Android Studio
4. **Espera** a que sincronice (primera vez puede tardar)
5. **Compila**: Menú `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
6. **Encuentra** tu APK en: `app/build/outputs/apk/debug/app-debug.apk`

### Método 2: Línea de comandos (Más rápido si ya tienes Java)

**Windows:**
```cmd
compilar.bat
```

**Linux/Mac:**
```bash
./compilar.sh
```

La APK aparecerá en: `app/build/outputs/apk/debug/app-debug.apk`

### Método 3: Sin instalar nada (Online)

Si no quieres instalar Android Studio, puedes usar:

**Appetize.io** (Gratis)
1. Ve a https://appetize.io/
2. Sube el proyecto comprimido
3. Compila online
4. Descarga la APK

## 📱 Instalar en tu móvil

1. **Copia** `app-debug.apk` a tu móvil (USB, email, Drive...)
2. **Habilita** instalación de apps desconocidas:
   - Ajustes → Seguridad → Orígenes desconocidos → ✅
3. **Abre** el archivo APK desde tu gestor de archivos
4. **Instala**

## 🎯 Cómo usar la app

1. Abre "Pantalla Blanca"
2. La pantalla se pondrá blanca automáticamente
3. **Toca** la pantalla para ver/ocultar controles
4. Botones disponibles:
   - 💡 **Alternar Brillo**: Máximo ↔ Normal
   - 👁️ **Ocultar Controles**: Pantalla limpia
   - ❌ **Salir**: Cerrar app

## ⚙️ Características

✅ Brillo automático al 100%
✅ Pantalla no se apaga
✅ Sin barras ni notificaciones
✅ Compatible Android 5.0+
✅ Sin anuncios ni permisos raros

## 🎨 Personalizar color

Para cambiar el color blanco a otro:

1. Abre `app/src/main/res/layout/activity_main.xml`
2. Busca: `android:background="#FFFFFF"`
3. Cambia a tu color favorito:
   - Negro: `#000000`
   - Rojo: `#FF0000`
   - Azul: `#0000FF`
   - Verde: `#00FF00`
   - Amarillo: `#FFFF00`
4. Recompila

## ❓ Problemas comunes

**"SDK not found"**
→ Instala Android SDK o usa Android Studio

**"Permission denied" en compilar.sh**
→ Ejecuta: `chmod +x compilar.sh`

**La app no cambia el brillo**
→ Algunos móviles requieren permiso manual en Ajustes

**Gradle tarda mucho**
→ Normal la primera vez. Descarga dependencias (~500MB)

## 📦 Contenido del proyecto

```
WhiteScreenApp/
├── compilar.sh          ← Script compilación Linux/Mac
├── compilar.bat         ← Script compilación Windows
├── README.md            ← Documentación completa
├── app/
│   └── src/main/
│       ├── java/        ← Código Java
│       ├── res/         ← Recursos (layout, strings)
│       └── AndroidManifest.xml
└── build.gradle         ← Configuración Gradle
```

## 💬 ¿Necesitas ayuda?

1. Lee el `README.md` completo
2. Revisa los mensajes de error al compilar
3. Verifica que tienes Java 11+ instalado
4. Asegúrate de tener conexión a internet (descarga dependencias)

## 🎁 Mejoras futuras

Ideas para personalizar:
- Añadir más colores (crear botones)
- Temporizador de apagado
- Control de intensidad de brillo
- Diferentes modos (SOS, estroboscópica)
- Widget para acceso rápido

¡Disfruta tu app! 🎉
