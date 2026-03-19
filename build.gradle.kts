val ktorVersion: String by project
val kafkaVersion: String by project
val coroutinesVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "2.3.0"
    id("io.ktor.plugin") version "3.4.0"
}

group = "io.github.savin000"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

kotlin {
    jvmToolchain(25)
}

dependencies {
    implementation(platform("io.ktor:ktor-bom:$ktorVersion"))

    implementation("io.ktor:ktor-server-websockets")
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")
    implementation("io.ktor:ktor-server-config-yaml")
    implementation("org.apache.kafka:kafka-clients:$kafkaVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation(kotlin("test"))
}