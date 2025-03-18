plugins {
    java
    id("com.gradleup.shadow") version "8.3.6"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.shadowJar {
    dependencies {
        include(dependency("dev.jorel:commandapi-bukkit-shade:9.7.0"))
    }
}

version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT")
    implementation("dev.jorel:commandapi-bukkit-shade:9.7.0")
}