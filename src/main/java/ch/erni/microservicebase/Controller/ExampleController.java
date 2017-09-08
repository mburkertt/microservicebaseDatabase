package ch.erni.microservicebase.Controller;

import ch.erni.microservicebase.Service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by buma on 19.01.2017.
 */

@RestController
public class ExampleController {

    @Resource(name = "uncompleteExample")
    private String uncompleteExample;

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping("/")
    public String exampleController() {
        return exampleService.getCompletedExample(uncompleteExample).getCompletedExample();
    }

    @RequestMapping("/executeTestcase")
    public String executeTestcase() {
        return exampleService.getCompletedExample(uncompleteExample).getCompletedExample();
    }

}

