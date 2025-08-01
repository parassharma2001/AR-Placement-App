# 🔩 AR Placement App for Android

A simple Android application that allows users to select a virtual drill from a list and place it in Augmented Reality using ARCore and Sceneform. Built using Jetpack Compose for UI and Sceneform for AR rendering.

---

## 📱 Features

- 🚀 Drill selection UI using Jetpack Compose
- 📄 Drill details page with dummy description and tips
- 🪄 Launch an AR session where the user can tap to place a virtual drill (represented as a 3D cube)
- 🎯 Tap-based plane detection and placement on detected surfaces
- ❌ Optional: Only one drill marker allowed at a time

---

## 🧰 Tech Stack

| Layer         | Technologies                               |
|--------------|--------------------------------------------|
| Language      | Kotlin                                     |
| UI            | Jetpack Compose, Material 3                |
| AR Engine     | ARCore, Sceneform 1.21 (Thomas Gorisse)    |
| Architecture  | Single Activity + Navigation via Intents   |
| Gradle Tools  | Android Gradle Plugin, Kotlin DSL          |

---
ar-placement-app/
├── app/
│ ├── src/main/
│ │ ├── java/com/example/arplacement/
│ │ │ ├── MainActivity.kt
│ │ │ ├── model/Drill.kt
│ │ │ ├── utils/DrillData.kt
│ │ │ └── ui/
│ │ │ ├── DrillSelectionScreen.kt
│ │ │ ├── DrillDetailActivity.kt
│ │ │ └── screen/ArActivity.kt
│ │ ├── res/layout/activity_ar.xml
│ │ └── AndroidManifest.xml
├── build.gradle
└── README.md


## 🛠️ Setup & Installation

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/ar-placement-app.git
   cd ar-placement-app

2. Open in Android Studio
3. Build & Sync Gradle
4. Run on a physical ARCore-supported Android device
   ⚠️ ARCore apps do not work on emulators.


🧠 Usage Flow

  Launch the app

  Choose a drill from the dropdown

  View its description and tips

  Tap "Launch AR"

  Move the device to detect a plane

  Tap to place a red cube representing the drill
  

🧾 License

This project is for educational/demo purposes only.


  
