pluginManagement {
    repositories {
        google()
        maven(url=("https://maven.aliyun.com/repository/public"))
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "UIdemo"
include(":app")
 