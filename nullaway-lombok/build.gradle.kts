/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.6/userguide/building_java_projects.html in the Gradle documentation.
 */

import net.ltgt.gradle.errorprone.*

plugins {
    `java-library`
    id("io.freefair.lombok") version "8.6"
    id("com.diffplug.spotless") version "6.18.0"
    id("net.ltgt.errorprone") version "3.0.1"
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("com.uber.nullaway:nullaway:0.10.22")
    compileOnly("org.jspecify:jspecify:0.3.0")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("org.jetbrains:annotations:24.0.0")
    compileOnly("org.checkerframework:checker-qual:3.42.0")
    compileOnly("jakarta.annotation:jakarta.annotation-api:2.1.1")
    errorprone("com.google.errorprone:error_prone_core:2.24.1")
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.addAll(listOf("-Xlint:unchecked", "-Xlint:deprecation", "-parameters"))
    sourceCompatibility = "17"
    targetCompatibility = "17"

    // enable error prone, but only check NullAway at ERROR level
    options.errorprone {
        disableAllChecks.set(true)
        error("NullAway")
        option("NullAway:AnnotatedPackages", "org.example")
    }
}

tasks.named<JavaCompile>("compileTestJava") {
    options.errorprone.isEnabled.set(false)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}