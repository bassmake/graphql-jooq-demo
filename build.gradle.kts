plugins {
    kotlin("jvm") version "1.5.10"
    id("com.diffplug.spotless") version "5.12.5"
}

group = "sk.bsmk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

spotless {
    kotlin {
        ktlint()
    }
    kotlinGradle {
        ktlint()
    }
}
