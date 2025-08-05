package com.vitalis.api.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.spring6.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templatemode.TemplateMode

@Configuration
open class ThymeleafConfig {


    @Bean
    open fun templateResolver(): ClassLoaderTemplateResolver {
        val templateResolver = ClassLoaderTemplateResolver()
        templateResolver.prefix = "/static/"
        templateResolver.suffix = ".html"
        templateResolver.templateMode = TemplateMode.HTML
        return templateResolver
    }

    @Bean
    open fun thymeleafViewResolver(templateEngine: SpringTemplateEngine): ThymeleafViewResolver {
        val resolver = ThymeleafViewResolver()
        resolver.templateEngine = templateEngine
        resolver.order = 1 // Öncelik sırası
        return resolver
    }

    @Bean
    open fun templateEngine(): SpringTemplateEngine {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(templateResolver()) // Resolvayı ayarla
        return templateEngine
    }


}
