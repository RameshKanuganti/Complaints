package com.valuepack.complaints.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(mbUSAInfo());
    }


    private ApiInfo mbUSAInfo() {
        ApiInfo appInfo = new ApiInfo(
                "Complaints",
                "Complaints Module",
                "1.0",
                "Terms and Services",
                //new Contact("Support Team", "https://www.mbusa.com/en/home", "starteai-support@mbusa.com"),
                "MyValuePack",
                "myvaluepack@mbusa.com",
                "http://www.apache.org/licenses/");
        return appInfo;
    }
}