package com.vitalis.api.configuration

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.resource.VersionResourceResolver


@Configuration
open class WebConfig : WebMvcConfigurer {
    val log = LoggerFactory.getLogger(WebConfig::class.java)

    init {
        log.info("Started to configuration of WebMvcConfigurer")
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/resources/**")
            .addResourceLocations("/resources/")
            .setCachePeriod(3600)
            .resourceChain(true)
            .addResolver(VersionResourceResolver().addContentVersionStrategy("/**"))
    }


    /**
     *
     * This shit configures "global" cross-origin request processing in application level. The configured CORS
     * mappings apply to annotated controllers, functional endpoints, and static
     * */

    override fun addCorsMappings(registry: CorsRegistry) {
        try {
            log.info("Started to configuration of origin sharing")
            //Enable cross-origin request for allow all endpoints "for specified origins"
            registry.addMapping("/**")
                //Set the origins for which cross-origin requests are allowed from a browser.
                // Please, refer to "CorsConfiguration". setAllowedOrigins(List) for format details and other considerations
                .allowedOrigins(
                    "https://www.bariatrack.com.tr",
                    "http://localhost:5173", //TODO-PRODUCTION : REMOVE THIS IN PRODUCTION.

                )//just allow 443 port (React app) in production
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // specify allowed methods
                .allowedHeaders("*")
                .maxAge(3600)
                .also {
                    log.info("Cross origin configured successfully...")
                }

        }catch (e:Exception){
            e.printStackTrace()
            log.info("Cross origin configured error, please have a look at logs.")
        }

    }



}