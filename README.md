# Pantalla Blanca - App Android

Una aplicación Android nativa que muestra una pantalla blanca con brillo máximo.

## Características

- ✅ Pantalla completamente blanca
- ✅ Brillo automático al máximo (100%)
- ✅ Mantiene la pantalla encendida (no se apaga automáticamente)
- ✅ Modo pantalla completa (sin barras de estado ni navegación)
- ✅ Controles ocultables con un toque en la pantalla
- ✅ Botón para alternar entre brillo máximo y normal
- ✅ Compatible con Android 5.0 (API 21) y superior

## Compilar la APK

### Opción 1: Con Android Studio (Recomendado)

1. **Instalar Android Studio**
   - Descarga desde: https://developer.android.com/studio
   - Instala Android Studio y los componentes necesarios

2. **Abrir el proyecto**
   - Abre Android Studio
   - File → Open → Selecciona la carpeta `WhiteScreenApp`
   - Espera a que Gradle sincronice el proyecto

3. **Compilar la APK**
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
   - Espera a que termine la compilación
   - Click en "locate" en la notificación o busca en: `app/build/outputs/apk/debug/app-debug.apk`

### Opción 2: Línea de comandos (Sin Android Studio)

1. **Requisitos previos**
   - Instalar JDK 11 o superior
   - Descargar Android Command Line Tools: https://developer.android.com/studio#command-tools
   - Configurar variable de entorno ANDROID_HOME

2. **Compilar**
   ```bash
   cd WhiteScreenApp
   ./gradlew assembleDebug
   ```
   (En Windows usa: `gradlew.bat assembleDebug`)

3. **Localizar la APK**
   - La APK estará en: `app/build/outputs/apk/debug/app-debug.apk`

### Opción 3: Compilación en línea (Sin instalar nada)

Puedes usar servicios como:
- **AppGyver** (https://www.appgyver.com/)
- **Appetize.io** (https://appetize.io/)
- **GitHub Actions** (configurando workflow de CI/CD)

## Instalar en tu móvil

1. **Habilitar orígenes desconocidos**
   - Ve a Ajustes → Seguridad
   - Activa "Orígenes desconocidos" o "Instalar aplicaciones desconocidas"

2. **Transferir la APK**
   - Copia `app-debug.apk` a tu móvil (por cable USB, email, etc.)

3. **Instalar**
   - Abre el archivo APK desde tu gestor de archivos
   - Pulsa "Instalar"

## Uso de la aplicación

1. Abre la app "Pantalla Blanca"
2. La pantalla se pondrá blanca automáticamente con brillo máximo
3. **Toca la pantalla** para mostrar/ocultar los controles
4. Usa los botones:
   - **Alternar Brillo**: Cambia entre brillo máximo y normal
   - **Ocultar Controles**: Oculta el panel de control
   - **Salir**: Cierra la aplicación

## Permisos

La app requiere los siguientes permisos:
- `WAKE_LOCK`: Para mantener la pantalla encendida
- `WRITE_SETTINGS`: Para ajustar el brillo (opcional)

## Estructura del proyecto

```
WhiteScreenApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/pantalblanca/
│   │       │   └── MainActivity.java
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml
│   │       │   └── values/
│   │       │       └── strings.xml
│   │       └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## Solución de problemas

### Error: "SDK not found"
- Asegúrate de tener Android SDK instalado
- Configura ANDROID_HOME en las variables de entorno

### Error al compilar con Gradle
- Verifica tu conexión a internet
- Ejecuta: `./gradlew clean` y luego `./gradlew assembleDebug`

### La app no controla el brillo
- En Android 6.0+, el permiso WRITE_SETTINGS requiere autorización manual
- Ve a Ajustes → Aplicaciones → Pantalla Blanca → Permisos

## Personalización

Para cambiar el color de la pantalla, edita `activity_main.xml`:
```xml
android:background="#FFFFFF"  <!-- Cambia a tu color preferido -->
```

Colores útiles:
- Blanco: `#FFFFFF`
- Negro: `#000000`
- Rojo: `#FF0000`
- Verde: `#00FF00`
- Azul: `#0000FF`

## Licencia

Proyecto de código libre. Úsalo como quieras.

## Autor

Creado con Claude AI
