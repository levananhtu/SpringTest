package com.lvat.SpringTest;

import com.lvat.SpringTest.consumingrest.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringTestApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Bean
    public void sayHello() {
        System.out.println("Hello, sucker");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return arg -> {
            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            assert quote != null;
            log.info(quote.toString());
        };
    }
}
