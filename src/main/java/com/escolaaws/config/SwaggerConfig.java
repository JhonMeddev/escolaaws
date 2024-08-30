package com.escolaaws.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI escolaawsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Escola Aws")
                        .description("Projeto Escola Aws - Jhonatan Medeiros")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Jhonatan Medeiros")
                                .url("https://jhonatanmedeiros.vercel.app/"))
                        .contact(new Contact()
                                .name("Jhonatan Medeiros")
                                .url("https://jhonatanmedeiros.vercel.app/")
                                .email("jhonatan1medeiros@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github.com/JhonMeddev"));


    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

        return openApi -> {
            openApi.getPaths().values()
                    .forEach(pathItem -> pathItem.readOperations()
                            .forEach(operation -> {

                                        ApiResponses apiResponses = operation.getResponses();

                                        apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                                        apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
                                        apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
                                        apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
                                        apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
                                        apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
                                        apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

                                    }
                            )
                    );
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }

}
