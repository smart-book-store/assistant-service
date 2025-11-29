plugins {
  java
  id("org.springframework.boot") version "3.5.6"
  id("io.spring.dependency-management") version "1.1.7"
}

group = "dev.cuong.smartbookstore"
version = "0.0.1-SNAPSHOT"
description = "assistant-service"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(25)
  }
}

repositories {
  mavenCentral()
}

extra["springAiVersion"] = "1.0.3"
extra["otelVersion"] = "2.20.0"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.ai:spring-ai-starter-model-openai")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  runtimeOnly("io.micrometer:micrometer-registry-prometheus")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  runtimeOnly("io.opentelemetry.javaagent:opentelemetry-javaagent:${property("otelVersion")}")
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
