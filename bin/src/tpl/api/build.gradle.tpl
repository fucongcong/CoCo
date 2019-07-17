plugins {
    id 'org.springframework.boot' version '2.1.5.RELEASE'
}
apply plugin: 'io.spring.dependency-management'
apply plugin: 'java'

//热重载
configurations {
    developmentOnly
    runtimeClasspath {
        extendsFrom developmentOnly
    }
}

dependencies {
    compile group: 'org.springframework', name: 'spring-core', version: '5.1.7.RELEASE'
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile 'mysql:mysql-connector-java'

    implementation 'com.auth0:java-jwt:3.8.1'

    compile "org.flywaydb:flyway-core:5.2.4"
    compile "org.apache.commons:commons-lang3"
    compile("org.springframework.boot:spring-boot-devtools")

    testCompile('org.springframework.boot:spring-boot-starter-test')

    compile project(":cm-common")
    compile project(":{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-service")
}

//打包
jar {
    enabled = true
}

bootJar {
    classifier = 'boot'
    mainClassName = '{{ group }}.{{ module }}.Application'

    launchScript {
        properties 'logFilename': '{{ modulePrefix }}-{{ module }}.log'
    }
}