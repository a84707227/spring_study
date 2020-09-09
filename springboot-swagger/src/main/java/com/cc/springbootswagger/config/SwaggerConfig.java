package com.cc.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("大宁", "http://localhost:8080/hello", "84707227@qq.com");
        ApiInfo apiInfo = new ApiInfo(
                "大宁 API",
                "hello world",
                "v1.0",
                "http://localhost:8080/hello",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
        return apiInfo;
    }

}
