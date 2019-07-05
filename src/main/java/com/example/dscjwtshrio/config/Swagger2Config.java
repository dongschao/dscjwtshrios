//package com.example.dscjwtshrio.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by 2fx0one on 25/5/2018.
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2Config {
//
//    //   访问可以查看api http://localhost:8080/swagger-ui.html
//
//    @Bean
////    @ConditionalOnProperty(name = "swagger2.ui.enable", havingValue = "true")
//    public Docket createRestApi() {
////        ParameterBuilder tokenPar = new ParameterBuilder();
////
////        List<Parameter> pars = new ArrayList<>();
////        tokenPar.name("Authorization").description("token!").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("").build();
////        pars.add(tokenPar.build());
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.dscjwtshrio"))
//                .paths(PathSelectors.any())
//                .build();
////                .globalOperationParameters(pars);
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("无为科技数据平台接口中心")
//                .description("无为科技数据平台接口中心")
//                .termsOfServiceUrl("http://www.0335.com/")
////                .contact("2fx0one")
//                .version("1.0")
//                .build();
//    }
//}
