plugins {
    id("java")
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
    implementation("org.jboss.weld.se:weld-se-core:5.1.3.Final")
}

sourceSets {
    main {
        output.setResourcesDir( file("${buildDir}/classes/java/main") )
    }
}