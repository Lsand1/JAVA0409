package com.test.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("网上商城后端接口文档")
                        .description("网上商城后端接口文档简单描述")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("帮助")
                        .url("https://127.0.0.1/docs"))
                ;
    }

//    @Bean
//    public GroupedOpenApi goodsApi() {
//
//        return GroupedOpenApi.builder()
//                .group("goods")
//                .pathsToMatch("/admin/**")
//                .build();
//    }
//    @Bean
//    public GroupedOpenApi userApi() {
//        return GroupedOpenApi.builder()
//                .group("user")
//                .pathsToMatch("/users/**")
//                .build();
//    }
}

