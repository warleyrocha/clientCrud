package br.com.brasilprev.clientcrud.util.swagger;

import br.com.brasilprev.clientcrud.model.Cliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.brasilprev.clientcrud.controller"))
                .build()
                .apiInfo(apiInfo())
                .ignoredParameterTypes(Cliente.class)
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .description("Header for Token JWT")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false).build()
                        )
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cadastro de Clientes")
                .description("\"API REST para Cadastro de Clientes\"")
                .version("1.0.0")
                .build();
    }
}

