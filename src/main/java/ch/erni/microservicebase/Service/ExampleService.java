package ch.erni.microservicebase.Service;

import ch.erni.microservicebase.Model.Example;
import ch.erni.microservicebase.Persistence.DAO.Person;

import java.util.List;

public interface ExampleService {
    Example getCompletedExample(Person person);

    Example getCompletedExample2(Person person);

    List<Person> getListOfPersons();
}
