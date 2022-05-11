package buildsrc

object Versions {
    // Build tools and SDK
    const val buildTools = "32.0.0"
    const val compileSdk = 31
    const val minSdk = 30
    const val targetSdk = 31
}

object Libraries {
    @JvmStatic
    val buildscriptPlugins: Array<String> = arrayOf(
        Gradle.gradlePlugin,
        Kotlin.gradlePlugin,
        Hilt.gradlePlugin,
    )

    object Gradle {
        private const val version = "7.2.0"

        const val gradlePlugin = "com.android.tools.build:gradle:$version"
    }

    object Kotlin {
        private const val version = "1.6.21"

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Coroutines {
        const val version = "1.6.1"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Hilt {
        const val version = "2.41"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hilt = "com.google.dagger:hilt-android:$version"

        object AnnotationProcessor {
            const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
        }
    }

    object Material {
        private const val version = "1.7.0-alpha01"

        const val material = "com.google.android.material:material:$version"
    }

    object Compose {
        const val version = "1.2.0-alpha08"
        private const val materialComposeVersion = "1.0.0-alpha10"

        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.1"

        const val foundation = "androidx.compose.foundation:foundation:$version"

        const val material3 = "androidx.compose.material3:material3:$materialComposeVersion"

        const val composeTooling = "androidx.compose.ui:ui-tooling:$version"
        const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
    }

    object Mavericks {
        const val version = "2.6.1"

        const val mavericksCompose = "com.airbnb.android:mavericks-compose:$version"
        const val mavericksHilt = "com.airbnb.android:mavericks-hilt:$version"
    }

    object Accompanist {
        private const val version = "0.24.7-alpha"

        const val accompanistPager = "com.google.accompanist:accompanist-pager:$version"
        const val accompanistPagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"
    }

    object Room {
        private const val version = "2.4.2"
        private const val versionRoomPaging = "2.5.0-alpha01"

        const val room = "androidx.room:room-ktx:$version"
        const val roomPaging = "androidx.room:room-paging:$versionRoomPaging"
        const val roomRuntime = "androidx.room:room-runtime:$version"

        object AnnotationProcessor {
            const val roomCompiler = "androidx.room:room-compiler:$version"
        }
    }

    object Coil {
        private const val version = "2.0.0-rc03"

        const val coil = "io.coil-kt:coil-compose:$version"
    }

    object Logcat {
        private const val version = "0.1"

        const val logcat = "com.squareup.logcat:logcat:$version"
    }

    object JavaX {
        private const val version = "1"

        const val javaXInject = "javax.inject:javax.inject:$version"
    }

    object KtLint {
        private const val version = "0.45.2"

        const val ktlint = "com.pinterest:ktlint:$version"
    }
}

object TestLibraries {

    object AndroidX {
        private const val coreVersion = "1.4.0"

        const val core = "androidx.test:core:$coreVersion"
        const val runner = "androidx.test:runner:$coreVersion"
        const val rules = "androidx.test:rules:$coreVersion"
    }

    object Coroutines {
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Libraries.Coroutines.version}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android-testing:${Libraries.Hilt.version}"
    }

    object Mavericks {
        const val mavericks = "com.airbnb.android:mavericks-testing:${Libraries.Mavericks.version}"
    }

    object Espresso {
        private const val version = "3.4.0"

        const val espressoCore = "androidx.test.espresso:espresso-core:$version"
    }

}
