package com.qj0r9j0vc2.boilerplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class BoilerplateApplication

fun main(args: Array<String>) {
    runApplication<BoilerplateApplication>(*args)
}
