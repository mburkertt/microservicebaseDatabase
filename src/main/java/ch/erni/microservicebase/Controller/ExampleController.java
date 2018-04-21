package ch.erni.microservicebase.Controller;

import ch.erni.microservicebase.Model.Example;
import ch.erni.microservicebase.Persistence.DAO.Person;
import ch.erni.microservicebase.Service.DataExampleService;
import ch.erni.microservicebase.Service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by buma on 19.01.2017.
 */

@RestController
public class ExampleController {

    private DataExampleService dataExampleService;
    private final ExampleService exampleService;

    @Autowired
    public ExampleController(DataExampleService dataExampleService, ExampleService exampleService) {
        this.dataExampleService = dataExampleService;
        this.exampleService = exampleService;
    }

    @RequestMapping("/1")
    public Example exampleController() {
        return exampleService.getCompletedExample(new Person());
    }

    @RequestMapping("/findall")
    public Iterable<Person> find() {
        return dataExampleService.findAllPersons();
    }

    @RequestMapping("/find")
    public Person findOne() {
        return dataExampleService.findPerson(1L);
    }

    @RequestMapping("/saveall")
    public String saveAll() {
        dataExampleService.saveAllPersons(exampleService.getListOfPersons());
        return "save:" + exampleService.getCompletedExample(new Person()).getPerson().toString();
    }

    @RequestMapping("/save")
    public String save() {
        dataExampleService.savePerson(exampleService.getCompletedExample(new Person()).getPerson());
        return "save:" + exampleService.getCompletedExample(new Person()).getPerson().toString();
    }


    @RequestMapping("/executeTestcase")
    public String executeTestcase() {
        return exampleService.getCompletedExample(new Person()).getCompletedExample();
    }

}

