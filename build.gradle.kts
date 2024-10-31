version = "${project.property("version")}"

allprojects {
    tasks {
        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }
    }
}

tasks {
    register("build") {
        dependsOn(":clean")
        dependsOn(":server:build")
        dependsOn(":client:build")
    }
    register("clean", Delete::class) {
        delete("${rootProject.projectDir}/build")
        dependsOn(":server:clean")
        dependsOn(":client:clean")
        dependsOn(":core:clean")
    }
}