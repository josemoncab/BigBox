import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
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