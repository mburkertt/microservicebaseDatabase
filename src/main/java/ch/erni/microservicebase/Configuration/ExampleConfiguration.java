package ch.erni.microservicebase.Configuration;

import ch.erni.microservicebase.Persistence.DAO.Person;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created by buma on 19.01.2017.
 */

@SpringBootConfiguration
public class ExampleConfiguration {


    @Bean("person")
    public Person exampleString() {
        return new Person();
    }
}
