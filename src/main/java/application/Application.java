package application;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@ComponentScan("candidate")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(apiInfo())
                .select()
                 .paths(regex("/candidate.*"))
                .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ryan Ylitalo Competency Matrix")
                .description("Spring REST Sample Outlining Ryan Ylitalo's Competencies")
                .termsOfServiceUrl("http://www.byteperceptions.com/")
                .contact("Ryan Ylitalo")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/rylitalo/ryan-ylitalo-competencies/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
