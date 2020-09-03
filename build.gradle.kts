plugins {
    java
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
}

group = "io.github.shinglem"

repositories {
    mavenLocal()
    maven("http://maven.aliyun.com/nexus/content/groups/public/")
    maven("https://dl.bintray.com/kotlin/exposed")
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://clojars.org/repo/")
    jcenter()
    mavenCentral()
}
val vertxVersion = "4.0.0.Beta1"
dependencies {

    implementation(group = "io.vertx", name = "vertx-service-proxy", version = vertxVersion)
    implementation(group = "io.vertx", name = "vertx-lang-kotlin", version = vertxVersion)
    implementation(group = "io.vertx", name = "vertx-lang-kotlin-coroutines", version = vertxVersion)
    implementation(group = "io.vertx", name = "vertx-codegen", version = vertxVersion)


    kapt(group = "io.vertx", name = "vertx-codegen", version = vertxVersion, classifier = "processor")
    kapt(group = "io.vertx", name = "vertx-lang-kotlin-gen", version = vertxVersion)

    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

kapt {

    arguments {
        arg("codegen.output", "${project.projectDir}/src/main/generated")
        arg("kapt.kotlin.generated" , "/")
        arg("codegen.kotlin.coroutines", "true")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptTask>() {
    doFirst {
        copy {
            from("${project.projectDir}/src/main/resources")
            into("${project.projectDir}/build/tmp/kapt3/src/main/resources")
        }
    }

}

