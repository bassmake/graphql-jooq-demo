plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"
    id("com.diffplug.spotless") version "5.12.5"
    id("org.springframework.boot") version "2.5.0"
    id("com.netflix.dgs.codegen") version "4.6.6"
}

group = "sk.bsmk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:4.2.0"))
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

tasks.generateJava {
    schemaPaths.add("$projectDir/src/main/resources/schema")
    packageName = "sk.bsmk.graphql"
    generateClient = true
}
