# 📖 ИНСТРУКЦИЯ ПО СБОРКЕ LITIFY APK

## 📋 Предварительные требования

### 1. Android Studio
- **Скачайте:** https://developer.android.com/studio
- **Минимум:** 8GB RAM, 10GB свободного места

### 2. Java Development Kit (JDK)
- **Требуется:** JDK 11 или выше
- **Скачайте:** https://www.oracle.com/java/technologies/downloads/

### 3. Android SDK
- **Target SDK:** Android 14 (API 34)
- **Min SDK:** Android 7.0 (API 24)

---

## 🚀 ПОШАГОВАЯ ИНСТРУКЦИЯ

### ШАГ 1: Клонирование проекта

```bash
git clone https://github.com/Liteexzv/Litifyx.git
cd Litifyx
```

### ШАГ 2: Открытие в Android Studio

1. **Откройте Android Studio**
2. **File → Open** (или **Welcome → Open**)
3. **Выберите папку `Litifyx`**
4. **Нажмите OK** и дождитесь загрузки (2-5 минут)

### ШАГ 3: Синхронизация Gradle

Android Studio автоматически синхронизирует Gradle. Если этого не произошло:
- **File → Sync Now** или **Ctrl+Alt+Y**

### ШАГ 4: Проверка SDK

1. **Tools → SDK Manager**
2. Убедитесь, что установлены:
   - ✅ Android SDK Platform 34
   - ✅ Build-Tools 34.x.x
3. **Apply → OK**

### ШАГ 5: Сборка Debug APK (Рекомендуется)

#### Способ 1: Через меню

1. **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Дождитесь "Build completed successfully"
3. Нажмите **locate**
4. Готовый файл: `app-debug.apk`

#### Способ 2: Через терминал

```bash
# Linux/Mac
./gradlew assembleDebug

# Windows
gradlew.bat assembleDebug

# Готовый APK в:
# app/build/outputs/apk/debug/app-debug.apk
```

---

## 📱 УСТАНОВКА НА УСТРОЙСТВО

### Через ADB (рекомендуется)

```bash
# 1. Подключите устройство через USB
# 2. Включите USB Debugging на телефоне

# 3. Установите Debug APK
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Через Android Studio

1. **Run → Run 'app'** (или **Shift + F10**)
2. Выберите устройство
3. Приложение установится автоматически

---

## 🎯 БЫСТРЫЙ СТАРТ (5 МИНУТ)

```bash
git clone https://github.com/Liteexzv/Litifyx.git
cd Litifyx
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

---

## ✅ ГОТОВО!

Теперь вы можете собирать и устанавливать Litify! 🎵