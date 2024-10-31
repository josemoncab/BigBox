import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("application")
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(project(":core"))
}

tasks {
    withType<ShadowJar> {
        archiveFileName.set("BigBox-server-${rootProject.version}.jar")
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
    mainClass.set("dev.josemoncab.BigBox-Server")
}