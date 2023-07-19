plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.9"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("org.json:org.json:chargebee-1.0")
    implementation("de.bixilon.javafx:javafx-svg:0.3")
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.json:json:20230618")
}

javafx {
    version = "13"
    modules("javafx.controls", "javafx.fxml")
}

tasks.test {
    useJUnitPlatform()
}