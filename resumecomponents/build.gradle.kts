import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.library)
    `maven-publish`
}

group = "com.iideprived.resumecomponents"
version = "1.0.0"

kotlin {
    configAsKobwebLibrary()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
            }
        }
    }
}

publishing {
    publications {
        register("mavenJsLibrary", MavenPublication::class) {
            from(components["kotlin"])
            groupId = "com.iideprived.resumecomponents"
            artifactId = "resumecomponents"
            version = "1.0.2"
        }
    }
}
