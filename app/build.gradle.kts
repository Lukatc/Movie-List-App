// საჭიროა პლაგინების გამოყენება Android და Kotlin მხარდაჭერისთვის.
plugins {
    // Android აპლიკაციის პლაგინი, რომელიც გამოიყენება Android აპლიკაციის შესაქმნელად.
    alias(libs.plugins.android.application)

    // Kotlin პლაგინი, რომელიც უზრუნველყოფს Kotlin პროგრამირების ენას აპლიკაციაში.
    alias(libs.plugins.kotlin.android)

    // KAPT პლაგინი Kotlin ანოტაციების დამუშავებისათვის (გამოიყენება, მაგალითად, Glide-სთვის).
    id("kotlin-kapt")
}

android {
    // აპლიკაციის უნიკალური იდენტიფიკატორი (ნეიმსფეისის დეფინიცია).
    namespace = "com.example.myapplication"

    // აპლიკაციის კომპილაციის SDK ვერსია (API დონე 35).
    compileSdk = 35

    // აპლიკაციის საწყისი კონფიგურაცია (ამ აპლიკაციაში მითითებულია მინიმალური და მიზნობრივი SDK).
    defaultConfig {
        // აპლიკაციის იდენტიფიკატორი.
        applicationId = "com.example.myapplication"

        // მინიმალური API დონე, სადაც აპლიკაცია მუშაობს (API დონე 24).
        minSdk = 24

        // მიზნობრივი API დონე, რომელიც ნიშნავს აპლიკაციის მიზნობრივ სერთიფიკატს.
        targetSdk = 35

        // ვერსიის კოდი, რომელიც განსაზღვრავს აპლიკაციის ვერსიას.
        versionCode = 1

        // ვერსიის სახელი, რომელიც გამოჩნდება მომხმარებელს.
        versionName = "1.0"

        // ტესტების პროცესორის განსაზღვრა.
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // აპლიკაციის კონფიგურაცია რელიზისთვის (პროუარდის კონფიგურაცია).
    buildTypes {
        release {
            // მინიფიკაციის გამორთვა (არ მოხდება კოდის შემცირება).
            isMinifyEnabled = false

            // პროუარდის კონფიგურაციის ფაილები (კოდის ოპტიმიზაციისთვის).
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Java-ს თავსებადობის განსაზღვრა.
    compileOptions {
        // განსაზღვრავს თუ რომელი Java ვერსიის მხარდაჭერით იმუშავებს აპლიკაცია (Java 11).
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Kotlin-ის ოპციები (JvmTarget-ის განსაზღვრა).
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // გამოყენებული ბიბლიოთეკები აპლიკაციისთვის.
    implementation("androidx.core:core-ktx:1.13.0") // Kotlin-ის მხარდაჭერა Android-ისთვის.
    implementation("androidx.appcompat:appcompat:1.6.1") // ActionBar-ის მხარდაჭერა და UI კომპონენტები.
    implementation("com.google.android.material:material:1.11.0") // Material Design კომპონენტები.
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // Flexible UI დიზაინი.
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit - API-სთვის კომუნიკაციისთვის.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson კონვერტერი Retrofit-სთვის.
    implementation("androidx.recyclerview:recyclerview:1.3.2") // RecyclerView - მონაცემების ძერწვა.
    implementation("com.github.bumptech.glide:glide:4.16.0") // Glide - გამოსახულებების დასატვირთავად.
    kapt("com.github.bumptech.glide:compiler:4.16.0") // Glide-ს კომპილატორი (KAPT).
}
