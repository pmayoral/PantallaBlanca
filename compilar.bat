@echo off
setlocal enabledelayedexpansion

echo =========================================
echo   Compilador de Pantalla Blanca App
echo =========================================
echo.

REM Verificar que estamos en el directorio correcto
if not exist "settings.gradle" (
    echo ❌ Error: Ejecuta este script desde la carpeta WhiteScreenApp
    pause
    exit /b 1
)

REM Verificar si gradlew existe
if not exist "gradlew.bat" (
    echo ⚠️  gradlew.bat no encontrado, creando wrapper...
    gradle wrapper
)

echo 🔧 Limpiando compilación anterior...
call gradlew.bat clean

echo.
echo 🏗️  Compilando APK...
call gradlew.bat assembleDebug

REM Verificar si la compilación fue exitosa
if %ERRORLEVEL% EQU 0 (
    echo.
    echo =========================================
    echo ✅ ¡Compilación exitosa!
    echo =========================================
    echo.
    echo 📱 Tu APK está en:
    echo    app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo 📋 Pasos siguientes:
    echo    1. Copia la APK a tu móvil
    echo    2. Habilita 'Orígenes desconocidos' en Ajustes
    echo    3. Instala la APK
    echo.
    
    REM Mostrar tamaño del APK
    set APK_PATH=app\build\outputs\apk\debug\app-debug.apk
    if exist "!APK_PATH!" (
        for %%A in ("!APK_PATH!") do set SIZE=%%~zA
        set /a SIZE_MB=!SIZE! / 1048576
        echo 📊 Tamaño del APK: !SIZE_MB! MB
    )
) else (
    echo.
    echo =========================================
    echo ❌ Error en la compilación
    echo =========================================
    echo.
    echo Revisa los mensajes de error arriba.
)

echo.
pause
