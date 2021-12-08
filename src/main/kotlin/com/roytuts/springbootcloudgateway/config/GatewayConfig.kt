package com.roytuts.springbootcloudgateway.config


import com.roytuts.springbootcloudgateway.filter.JwtAuthenticationFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GatewayConfig {
    @Autowired
    private val filter: JwtAuthenticationFilter? = null
    @Bean
    fun routes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes().route("AUTHO-SERVICE") { r: PredicateSpec -> r.path("/auth/**").filters { f: GatewayFilterSpec -> f.filter(filter) }.uri("http://localhost:9300/") }
            .route("WALLETMONGODB-SERVICE") { r: PredicateSpec -> r.path("/wallet/**").filters { f: GatewayFilterSpec -> f.filter(filter) }.uri("http://localhost:9800/") }.build()

    }
}