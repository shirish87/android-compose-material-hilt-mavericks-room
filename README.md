
# MVVM Android Jetpack Compose Template

Created because figuring out library versions that _actually_ work with each other can be challenging.


## Components

* [Jetpack Compose](https://developer.android.com/jetpack/compose) (No XML views)
* [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) (No Fragments)
* [Material Design 3](https://m3.material.io)
* [Hilt](https://dagger.dev/hilt/) (DI)
* [Mavericks](https://airbnb.io/mavericks/) (VM, reactive state management)
* [Room](https://developer.android.com/jetpack/androidx/releases/room)
* [KtLint](https://ktlint.github.io/)
* [Logcat](https://github.com/square/logcat)


See [dependencies.kt](buildSrc/src/main/java/buildsrc/dependencies.kt) for configured libraries and versions.


## Gradle Scripts

Configuration as code: Project components are configured behind the scenes with suitable defaults by a custom [AutoConfigBuildPlugin](buildSrc/src/main/java/buildsrc/AutoConfigBuildPlugin.kt) gradle plugin.


This allows for minimalist `build.gradle` scripts for:

### Project Root
```
import buildsrc.*

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        Libraries.buildscriptPlugins.each { lib ->
            classpath lib
        }
    }
}

apply plugin: AutoConfigBuildPlugin

autoConfigBuild {
    javaVersion = JavaVersion.VERSION_11.toString()
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```


### App Module

```
import buildsrc.Libraries
import buildsrc.TestLibraries

plugins {
    id 'com.android.application'
}

dependencies {
    implementation Libraries.Compose.activityCompose
    implementation Libraries.Compose.navigationCompose

    androidTestImplementation TestLibraries.Espresso.espressoCore
}
```


### Library Modules
```
import buildsrc.Libraries

plugins {
    id 'com.android.library'
}

dependencies {
    api Libraries.JavaX.javaXInject

    kapt Libraries.Room.AnnotationProcessor.roomCompiler
    api Libraries.Room.roomRuntime
    implementation Libraries.Room.room
    implementation Libraries.Room.roomPaging
}
```
