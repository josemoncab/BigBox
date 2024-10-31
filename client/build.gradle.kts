import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("application")
    alias(libs.plugins.shadow)
    alias(libs.plugins.javafx)
}

dependencies {
    implementation(project(":core"))
}

tasks {
    withType<ShadowJar> {
        archiveFileName.set("BigBox-client-${rootProject.version}.jar")
    }

    build {
        dependsOn("shadowJar")
        doLast {
            copy {
                from(shadowJar)
                into("${rootProject.projectDir}/build/libs")
            }

        }
    }
}

application {
    mainClass.set("dev.josemoncab.BigBox-Client")
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}