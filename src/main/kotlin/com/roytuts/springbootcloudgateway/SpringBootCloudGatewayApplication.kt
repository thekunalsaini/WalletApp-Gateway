package com.roytuts.springbootcloudgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient


@EnableEurekaClient
@SpringBootApplication
class SpringBootCloudGatewayApplication

fun main(args: Array<String>) {
	runApplication<SpringBootCloudGatewayApplication>(*args)
}
