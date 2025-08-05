pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.10"
    }
}
rootProject.name = "vitalis"
include(":api")
include(":service")
include(":data")
include(":common")

