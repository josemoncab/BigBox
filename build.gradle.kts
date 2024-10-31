version = "${project.property("version")}"

allprojects {
    repositories {
        mavenCentral()
    }

    tasks {
        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }
    }
}

tasks {
    register("build") {
        group = "project"

        dependsOn(":clean")
        dependsOn(":server:build")
        dependsOn(":client:build")
    }
    register("clean", Delete::class) {
        group = "project"

        delete("${rootProject.projectDir}/build")
        dependsOn(":server:clean")
        dependsOn(":client:clean")
        dependsOn(":core:clean")
    }
}