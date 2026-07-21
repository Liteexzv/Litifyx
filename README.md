# 🎵 Litify - Offline Music Player

Современное приложение для воспроизведения музыки на Android с поддержкой контроля скорости и минималистичным дизайном.

## ✨ Основные функции

- **🎵 Воспроизведение музыки** - MP3, WAV, FLAC, OGG форматы
- **⚡ Контроль скорости** - от 0.5x до 2.0x
- **❤️ Избранные песни** - Сохраняйте любимые треки
- **👤 Профиль пользователя** - Настройки и предпочтения
- **🎨 Минималистичный дизайн** - Фиолетово-розовые градиенты
- **🎬 Плавные анимации** - На всех переходах

## 🚀 Быстрый старт

### Требования
- Android 7.0+ (API 24)
- Android Studio
- JDK 11+

### Установка

1. **Клонируйте репозиторий:**
```bash
git clone https://github.com/Liteexzv/Litifyx.git
cd Litifyx
```

2. **Откройте в Android Studio:**
   - File → Open → Выберите папку проекта

3. **Соберите APK:**
   - Build → Build APK(s)

4. **Установите на устройство:**
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 📱 Интерфейс

### Экраны
- **Home** - Список всех песен
- **Player** - Управление воспроизведением и скоростью
- **Favorites** - Избранные песни
- **Profile** - Настройки пользователя

## 🎛️ Скорости воспроизведения

- 0.5x - Замедление в 2 раза
- 0.75x - Замедление на 25%
- 1.0x - Нормальная скорость
- 1.25x - Ускорение на 25%
- 1.5x - Ускорение в 1.5 раза
- 2.0x - Ускорение в 2 раза

## 🏗️ Архитектура

- **MVVM** - Clean Architecture
- **Room Database** - Локальное хранилище
- **Kotlin Coroutines** - Асинхронные операции
- **Navigation Component** - Навигация между экранами

## 📦 Технологии

- Kotlin
- Android Architecture Components
- Material Design 3
- ExoPlayer (Media3)
- Room Database
- Glide (Image Loading)
- Lottie (Animations)

## 📋 Структура проекта

```
app/src/main/
├── kotlin/com/litify/musicplayer/
│   ├── data/
│   ├── service/
│   └── ui/
├── res/
│   ├── anim/
│   ├── drawable/
│   ├── layout/
│   ├── menu/
│   ├── navigation/
│   └── values/
└── AndroidManifest.xml
```

## 🔧 Разработка

### Запуск отладки
```bash
./gradlew assembleDebug
./gradlew assembleRelease
```

## 📄 Лицензия

MIT License

## 👨‍💻 Автор

Создано с ❤️ для любителей музыки

---

**Litify - Your Music, Your Way, Offline 🎵**