# 💫 C-ViewToShimmerEffect

Librería Android (Kotlin) que proporciona un **layout de shimmer reutilizable** para listados típicos:  
🖼️ Imagen a la izquierda  
🔤 Título/nombre a la derecha  
📄 Descripción debajo del título  

Ideal para mostrar un estado de carga elegante mientras se cargan datos desde una API, base de datos o red.

---

## 📲 Instalación

### Paso 1: Agrega JitPack a tu `settings.gradle.kts`

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") } //Agregas esta línea
    }
}
```
### Paso 2: Agrega la dependencia
Opción A: Directamente en build.gradle.kts (app)
```kotlin
dependencies {
    implementation("com.github.BreydenN:C-ViewToShimmerEffect:1.0.0")
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
}
```

Opción B: Usando libs.versions.toml (recomendado para proyectos organizados)
En gradle/libs.versions.toml:
```kotlin
[versions]
viewToShimmer = "1.0.0"
shimmerEffect = "0.5.0"

[libraries]
viewToShimmer = { group = "com.github.BreydenN", name = "C-ViewToShimmerEffect", version.ref = "viewToShimmer" }
shimmerEffect = { group = "com.facebook.shimmer", name = "shimmer", version.ref = "shimmerEffect"}
```

Luego en build.gradle.kts (app):
```kotlin
dependencies {
    implementation(libs.viewToShimmer)
    implementation(libs.shimmerEffect)
}
```
### Paso 3: Agrega viewBinding
build.gradle.kts (app):
```kotlin
android {
    kotlinOptions {
        ...
    }
    // Agregas viewBinding
    viewBinding {
        enable = true
    }
}
```

## 🧩 Cómo usarlo
Agrega ShimmerFrameLayout en tu layout (de Facebook):
```kotlin
<com.facebook.shimmer.ShimmerFrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:shimmer_auto_start="true">

        <LinearLayout
            android:id="@+id/linearLoading"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:visibility="gone">

            <include layout="@layout/activity_loading_effect" />  <!-- Añades unas 3 o 4 veces -->
            <include layout="@layout/activity_loading_effect" />
            <include layout="@layout/activity_loading_effect" />

        </LinearLayout>
    </com.facebook.shimmer.ShimmerFrameLayout>
```
Controla la visibilidad desde tu Fragment/Activity:
```kotlin
// Mostrar carga
binding.linearLoading.visibility = View.VISIBLE

// Ocultar cuando los datos lleguen
binding.linearLoading.visibility = View.GONE
```
✅ La librería solo proporciona @layout/activity_loading_effect.<br>
❗ El ShimmerFrameLayout y su contenedor los debes crear tú.

