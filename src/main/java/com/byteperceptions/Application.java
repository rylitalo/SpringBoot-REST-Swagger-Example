package com.byteperceptions;
/*
 * Copyright 2016 Ryan Ylitalo and BytePerceptions LLC. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.byteperceptions.candidate.Candidate;
import com.byteperceptions.candidate.CandidateRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
//@ComponentScan("com.byteperceptions")
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("candidate")
                .apiInfo(apiInfo())
                .select()
                 .paths(regex("/candidate.*"))
                .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("SpringBoot-REST-Swagger")
                .description("A simple SpringBoot REST Application integrated with Swagger")
                .termsOfServiceUrl("http://www.byteperceptions.com/")
                .contact("Ryan Ylitalo")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/rylitalo/SpringBoot-REST-Swagger-Example/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
    
    @Bean
    public CommandLineRunner initializeDb(CandidateRepository repository){
        return (args) -> {
            repository.deleteAll();
             String[] competencies = {"Strategic Problem Solving and Analytical Skills", "Design and Architecture Skills", "Customer Focus", "Communication", "Self-Awareness"};
        	
            repository.save(new Candidate(1, "Ryan Ylitalo", competencies, "http://www.ryanylitalo.com"));
            repository.save(new Candidate(2, "BadRequest Candidate", competencies, "xxasd://www.someinvalidurl.com"));
            repository.save(new Candidate(3, "Abe Lincoln", competencies, "http://www.abelincoln.com"));
            
        };
    }
}
