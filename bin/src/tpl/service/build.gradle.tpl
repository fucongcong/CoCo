plugins {
    id 'net.ltgt.apt' version '0.20'
}
apply plugin: 'net.ltgt.apt-idea'
apply plugin: 'net.ltgt.apt-eclipse'
apply plugin: 'java'

dependencies {
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.8'

    implementation "org.mapstruct:mapstruct:1.3.0.Final"
    //compileOnly 'org.mapstruct:mapstruct-processor:1.3.0.Final'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.3.0.Final'
    testAnnotationProcessor 'org.mapstruct:mapstruct-processor:1.3.0.Final'

    compileOnly 'org.projectlombok:lombok:1.18.8'
    annotationProcessor 'org.projectlombok:lombok:1.18.8'

    compile group: 'org.springframework', name: 'spring-core', version: '5.1.7.RELEASE'
    compile project(":{{ modulePrefix }}-{{ module }}:{{ modulePrefix }}-{{ module }}-dao")

    compile project(":cm-common")
}

tasks.withType(JavaCompile) {
    options.compilerArgs = [
            '-Amapstruct.suppressGeneratorTimestamp=false',
            '-Amapstruct.defaultComponentModel=spring'
    ]
}
