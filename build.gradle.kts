import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    `java-gradle-plugin`
    java
    id("com.gradle.plugin-publish") version "0.10.0"
}

group = "com.tylerthrailkill.gradle"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

gradlePlugin {
    plugins {
        create("mitLicensePlugin") {
            id = "tylerthrailkill.nebula-mit-license"
            displayName = "nebula-mit-license"
            description = "Adds the MIT License to the POM of a nebula publication to allow for publishing to Maven Central."
            implementationClass = "com.tylerthrailkill.gradle.maven.license.MavenMitLicensePlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/snowe2010/nebula-mit-license"
    vcsUrl = "git@github.com:snowe2010/nebula-mit-license.git"
    tags = listOf("nebula", "license", "mit", "maven central")
}