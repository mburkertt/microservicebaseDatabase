package ch.erni.microservicebase.Service;

import ch.erni.microservicebase.Model.Example;
import org.springframework.stereotype.Service;

/**
 * Created by buma on 19.01.2017.
 */

@Service
public class ExampleService {

    public Example getCompletedExample(String uncompleteExample) {
        String completedExample = uncompleteExample.replaceAll("un", "");
        Example example = new Example();
        example.setCompletedExample(completedExample);
        return example;
    }

}
