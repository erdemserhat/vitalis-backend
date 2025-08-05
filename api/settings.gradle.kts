pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.10"
    }
}


rootProject.name = "api"
include(":service")
include(":common")
include(":data")
