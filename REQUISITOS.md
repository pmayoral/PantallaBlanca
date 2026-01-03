# 🔧 REQUISITOS DEL SISTEMA

## Para compilar la app Android

### Opción 1: Android Studio (Más fácil)

**Requisitos mínimos:**
- Sistema operativo: Windows 7/8/10/11, macOS 10.14+, o Linux (Ubuntu 18.04+)
- RAM: 8 GB (recomendado 16 GB)
- Espacio en disco: 8 GB para Android Studio + 4 GB para Android SDK
- Resolución de pantalla: 1280x800 mínimo
- Conexión a internet para descargar dependencias

**Descarga:**
- https://developer.android.com/studio

**Componentes que se instalan automáticamente:**
- Java JDK
- Android SDK
- Gradle
- Emulador Android (opcional)

**Tiempo estimado de instalación:** 30-60 minutos (primera vez)

---

### Opción 2: Línea de comandos (Más rápido)

**Requisitos previos:**

1. **Java JDK 11 o superior**
   - Verifica: `java -version`
   - Descarga: https://adoptium.net/
   
2. **Android Command Line Tools**
   - Descarga: https://developer.android.com/studio#command-tools
   - Descomprime en una carpeta (ej: C:\Android\cmdline-tools)
   
3. **Variables de entorno**
   ```
   ANDROID_HOME = C:\Android
   JAVA_HOME = C:\Program Files\Java\jdk-11
   ```
   
4. **Conexión a internet**
   - Necesaria para descargar dependencias de Gradle (~500MB primera vez)

**Tiempo estimado:** 5-10 minutos (si ya tienes Java instalado)

---

### Opción 3: Compilación online (Sin instalar nada)

**Servicios gratuitos:**

1. **Replit** (https://replit.com)
   - Crear cuenta gratuita
   - Subir proyecto
   - Ejecutar en la nube
   
2. **GitHub Codespaces** (https://github.com/features/codespaces)
   - 60 horas gratis al mes
   - Entorno completo en navegador
   
3. **Gitpod** (https://www.gitpod.io/)
   - 50 horas gratis al mes
   - Compatible con Android

**Requisitos:**
- Navegador moderno (Chrome, Firefox, Edge)
- Conexión a internet estable
- Cuenta de usuario (gratuita)

**Ventajas:**
- No instalas nada en tu PC
- Funciona desde cualquier computadora
- Configuración automática

---

## Para instalar la APK en tu móvil

**Requisitos del dispositivo:**
- Android 5.0 (Lollipop) o superior
- ~2 MB de espacio libre
- Permisos para instalar apps de orígenes desconocidos

**Versiones de Android soportadas:**
- ✅ Android 14 (2023)
- ✅ Android 13 (2022)
- ✅ Android 12 (2021)
- ✅ Android 11 (2020)
- ✅ Android 10 (2019)
- ✅ Android 9 Pie (2018)
- ✅ Android 8 Oreo (2017)
- ✅ Android 7 Nougat (2016)
- ✅ Android 6 Marshmallow (2015)
- ✅ Android 5 Lollipop (2014)

**No funciona en:**
- ❌ Android 4.4 KitKat o inferior
- ❌ iOS / iPhone
- ❌ Windows Phone

---

## Espacio en disco necesario

### Durante el desarrollo:
- Proyecto fuente: ~1 MB
- Dependencias Gradle: ~500 MB (primera compilación)
- Build cache: ~200 MB
- Android SDK: ~2-4 GB
- **Total: ~3-5 GB**

### APK final:
- Tamaño de la APK: **~2 MB**

---

## Conexión a internet

**Necesaria para:**
- Primera compilación (descarga dependencias)
- Actualizar Android SDK
- Descargar herramientas de compilación

**No necesaria para:**
- Compilar después de la primera vez (usa caché)
- Usar la app una vez instalada

---

## Tiempo de compilación

**Primera compilación:**
- Con Android Studio: 5-10 minutos
- Línea de comandos: 3-5 minutos
- (Descarga dependencias)

**Compilaciones posteriores:**
- Con Android Studio: 30-60 segundos
- Línea de comandos: 10-30 segundos
- (Usa caché de Gradle)

---

## Soluciones a problemas comunes

### "No se encuentra Java"
```bash
# Verifica instalación
java -version

# Instala Java JDK 11 o superior
https://adoptium.net/
```

### "SDK not found"
```bash
# Configura variable de entorno
ANDROID_HOME = ruta/a/tu/android/sdk
```

### "Out of memory" durante compilación
```
# Edita gradle.properties
org.gradle.jvmargs=-Xmx4096m
```

### "Gradle daemon stopped"
```bash
# Limpia y reintenta
./gradlew clean
./gradlew assembleDebug
```

---

## Alternativas sin compilar

Si no quieres compilar la app, puedes usar la versión web HTML:

**Ventajas:**
- No requiere instalación
- Funciona en cualquier navegador
- Puede añadirse a pantalla de inicio
- Actualización instantánea

**Desventajas:**
- No puede forzar brillo al máximo en todos los dispositivos
- Requiere mantener navegador abierto

---

## ¿Qué opción elegir?

### Elige Android Studio si:
- ✅ Es tu primera vez
- ✅ Quieres ver el código con interfaz gráfica
- ✅ Planeas modificar la app
- ✅ Tienes espacio en disco

### Elige Línea de comandos si:
- ✅ Ya tienes Java instalado
- ✅ Prefieres rapidez
- ✅ Tienes experiencia con terminal
- ✅ Espacio en disco limitado

### Elige Compilación online si:
- ✅ No quieres instalar nada
- ✅ Tu PC es lenta
- ✅ Solo necesitas la APK una vez
- ✅ Tienes buena conexión a internet

---

## Soporte y ayuda

**Documentación oficial:**
- Android Studio: https://developer.android.com/studio/intro
- Gradle: https://gradle.org/
- Java JDK: https://adoptium.net/

**Tutoriales en español:**
- https://developer.android.com/courses
- https://www.youtube.com/results?search_query=compilar+apk+android

**Archivos del proyecto:**
- `README.md` - Documentación completa
- `GUIA_RAPIDA.md` - Inicio rápido
- `compilar.sh` / `compilar.bat` - Scripts de compilación
