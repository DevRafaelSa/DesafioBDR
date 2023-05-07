package br.com.rafael.desafiobdr.backend.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

    //http://localhost:8085/swagger-ui/index.html
    @Bean
    public OpenAPI baseOpenApi() {

        Contact contact = new Contact();
        contact.setEmail("rafael.santos@codata.pb.gov.br");
        contact.setName("Rafael Sá");
        contact.setUrl("https://www.linkedin.com/in/rafaelsasantos/");


        return new OpenAPI().info(new Info().title("SISTEMA LOTEP").version("1.0.0").description("API que dispõe dos serviços do Sistema Lotep")
                .contact(contact));

    }

}
