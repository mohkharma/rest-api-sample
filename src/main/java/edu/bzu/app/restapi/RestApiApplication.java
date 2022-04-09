package edu.bzu.app.restapi;

import edu.bzu.app.restapi.entity.Category;
import edu.bzu.app.restapi.payLoad.CategoryDto;
import edu.bzu.app.restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(CategoryService categoryService) {
        return args -> {
            try {
                CategoryDto instance;
                Random random = new Random(System.currentTimeMillis());
                for (int i = 0; i < 2; i++) {
                    instance = new CategoryDto();
                    instance.setName("default category " + random.nextInt());
                    instance.setDescription("default category " + random.nextInt());
                    categoryService.createCategory(instance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * a bean exploits the Inversion of Control feature by which an object defines its dependencies without creating them
     * Spring @Bean annotation tells that a method produces a bean to be managed by the Spring container.
     * @Bean is a method-level annotation and a direct analog of the XML <bean/> element.
     * The annotation supports most of the attributes offered by <bean/> ,
     * such as: init-method , destroy-method , autowiring , lazy-init , dependency-check , depends-on and scope .
     * @return RestTemplate instance
     */
    @Bean("restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
