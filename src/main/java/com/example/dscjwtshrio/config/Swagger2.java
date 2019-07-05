package com.example.dscjwtshrio.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Authorization").description("token!").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("").build();
//        pars.add(tokenPar.build());

        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("Token").description("user ticket")//Token 以及Authorization 为自定义的参数，session保存的名字是哪个就可以写成那个
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.dscjwtshrio"))
                .paths(PathSelectors.any())
                .build()
//                .securitySchemes(Lists.newArrayList(apiKey()))
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("无为科技数据平台接口中心")
                .description("无为科技数据平台接口中心")
                .termsOfServiceUrl("http://www.0335.com/")
                .contact("无为科技-DongSc")
                .version("1.0.1")
                .build();
    }
//    private ApiKey apiKey() {
//        return new ApiKey("apikey", "Authorization", "header");
//    }
}
