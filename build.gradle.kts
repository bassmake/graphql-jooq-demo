plugins {
    kotlin("jvm") version "1.5.30-RC"
    kotlin("plugin.spring") version "1.5.10"
    id("com.diffplug.spotless") version "5.14.2"
    id("org.springframework.boot") version "2.5.3"
    id("com.netflix.dgs.codegen") version "5.0.5"
}

group = "sk.bsmk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:4.5.1"))
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.liquibase:liquibase-core")
    implementation("com.h2database:h2")
}

spotless {
    kotlin {
        targetExclude("**/generated/**")
        ktlint()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = "11"
    }
}

tasks.generateJava {
    schemaPaths.add("$projectDir/src/main/resources/schema")
    packageName = "sk.bsmk.graphql"
    generateClient = true
}
