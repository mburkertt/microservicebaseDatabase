package ch.erni.microservicedatabase.Service;

import ch.erni.microservicedatabase.Model.Example;
import ch.erni.microservicedatabase.Persistence.DAO.Person;

import java.util.List;

public interface ExampleService {
    Example getCompletedExample(Person person);

    Example getCompletedExample2(Person person);

    List<Person> getListOfPersons();
}
