object Config {
    const val minimumSdkVersion = 21
    const val compileSdkVersion = 32
    const val targetSdkVersion = 32
    const val applicationId = "com.kaguu.template"
    const val versionCode = 1
    const val versionName = "0.0.1"
    const val testInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    // tools
    const val android = "7.1.1"
    const val kotlin = "1.6.10"

    // core
    const val ktx = "1.7.0"
    const val appcompat = "1.4.1"
    const val material = "1.5.0"
    const val activity = "1.2.0"
    const val fragment = "1.3.0"
    const val lifecycle = "2.3.0"
    const val navigation = "2.3.3"
    const val worker = "2.5.0"
    const val multiDex = "2.0.1"


    // image
    const val coil = "1.1.1"

    // network
    const val retrofit = "2.9.0"
    const val loging = "4.9.1"
    const val timber = "5.0.1"
    const val gson = "2.9.0"

    // local database
    const val roomRuntime = "2.3.0"
    const val roomKtx = "2.3.0"
    const val roomCompiler = "2.3.0"


    // di
    const val koin = "3.1.5"


    // firebase
    const val firebaseBoM = "29.1.0"

    // test
    const val junit = "4.13.1"
    const val junitTest = "1.1.2"
    const val espressoTest = "3.3.0"
    const val mockitoCore = "2.28.2"
    const val mockitoInline = "2.13.0"
    const val coreTesting = "2.1.0"
    const val kotlinxCoroutinesTest = "1.5.1"
    const val mockk = "1.12.0"
    const val turbine = "0.6.0"
    const val mockitoKotlin = "2.2.0"
    const val kluentAndroid = "1.68"

    // other
    const val localization = "1.2.11"
}

object Dependencies {
    const val androidCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val androidAppcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"

    const val worker = "androidx.work:work-runtime-ktx:${Versions.worker}"

    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val firebaseBoM = "com.google.firebase:firebase-bom:${Versions.firebaseBoM}"
    const val auth = "com.google.firebase:firebase-auth-ktx"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val messaging = "com.google.firebase:firebase-messaging-ktx"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val realtimeDatabase = "com.google.firebase:firebase-database-ktx"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val localization = "com.akexorcist:localization:${Versions.localization}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val httpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.loging}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntime}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompiler}"

    //test
    const val junit = "junit:junit:${Versions.junit}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    const val espressoTest = "androidx.test.espresso:espresso-core:${Versions.espressoTest}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val kotlinxCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutinesTest}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val kluentAndroid = "org.amshove.kluent:kluent-android:${Versions.kluentAndroid}"
}

