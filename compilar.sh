#!/bin/bash

echo "========================================="
echo "  Compilador de Pantalla Blanca App"
echo "========================================="
echo ""

# Verificar que estamos en el directorio correcto
if [ ! -f "settings.gradle" ]; then
    echo "❌ Error: Ejecuta este script desde la carpeta WhiteScreenApp"
    exit 1
fi

# Verificar si gradlew existe
if [ ! -f "gradlew" ]; then
    echo "⚠️  gradlew no encontrado, creando wrapper..."
    gradle wrapper
fi

# Dar permisos de ejecución a gradlew
chmod +x gradlew

echo "🔧 Limpiando compilación anterior..."
./gradlew clean

echo ""
echo "🏗️  Compilando APK..."
./gradlew assembleDebug

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo ""
    echo "========================================="
    echo "✅ ¡Compilación exitosa!"
    echo "========================================="
    echo ""
    echo "📱 Tu APK está en:"
    echo "   app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "📋 Pasos siguientes:"
    echo "   1. Copia la APK a tu móvil"
    echo "   2. Habilita 'Orígenes desconocidos' en Ajustes"
    echo "   3. Instala la APK"
    echo ""
    
    # Mostrar tamaño del APK
    APK_PATH="app/build/outputs/apk/debug/app-debug.apk"
    if [ -f "$APK_PATH" ]; then
        SIZE=$(du -h "$APK_PATH" | cut -f1)
        echo "📊 Tamaño del APK: $SIZE"
    fi
else
    echo ""
    echo "========================================="
    echo "❌ Error en la compilación"
    echo "========================================="
    echo ""
    echo "Revisa los mensajes de error arriba."
    exit 1
fi
