package com.szpnr.plsup.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * API说明配置类,可通过http://ip:port/contextpath/swagger-ui.html查看和测试API
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.szpnr.plsup.base.controller"))
                .apis(basePackage("com.szpnr.plsup.base.controller,com.szpnr.plsup.common.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage){
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>,Boolean> handlerPackage(final String basePackage){
        return input ->{
            for(String strPackage:basePackage.split(",")){
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if(isMatch){
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
