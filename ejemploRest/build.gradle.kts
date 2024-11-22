plugins {
    id("java")
    id("application")
}

group = "com.uce.distribuida.rh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
java{
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation("io.helidon.webserver:helidon-webserver:4.1.4")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")

}

tasks.test {
    useJUnitPlatform()
}