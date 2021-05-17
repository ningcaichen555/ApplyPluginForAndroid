buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven {
            setUrl("http://127.0.0.1:8081/repository/maven-public/")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha15")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
        classpath("com.caichen:pluginProject:0.0.2")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        maven {
            setUrl("http://127.0.0.1:8081/repository/maven-public/")
        }
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}