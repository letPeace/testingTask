plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-core
    implementation("org.hibernate:hibernate-core:6.1.5.Final")
    implementation("com.intellij:annotations:12.0")
    implementation("org.postgresql:postgresql:42.5.0")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}