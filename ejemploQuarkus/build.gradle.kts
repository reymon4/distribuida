plugins {
    id("java")
    id("io.quarkus") version "3.17.0"
    id("io.freefair.lombok") version "8.11"

}

group = "com.uce.distribuida.rh"
version = "1.0.0-SNAPSHOT"
repositories {
    mavenCentral()
}

java{
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

var quarkusVersion="3.17.0"
dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))
    //CDI
    implementation("io.quarkus:quarkus-arc")
    //REST
    implementation("io.quarkus:quarkus-rest")
    //JSON
    implementation("io.quarkus:quarkus-rest-jsonb")
    //JPA
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    //JDBC
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("org.postgresql:postgresql:42.7.4")


}




tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}