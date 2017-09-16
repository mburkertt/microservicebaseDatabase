package ch.erni.microservicebase.Service;

import ch.erni.microservicebase.Model.Example;
import ch.erni.microservicebase.Persistence.DAO.Person;
import org.springframework.stereotype.Service;
import sun.awt.util.IdentityArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by buma on 19.01.2017.
 */

@Service
public class ExampleService {

    private static final long DATE = 2222222222L;

    public Example getCompletedExample(Person person) {
        person.setCountry(new Locale("DE", "DEU"));
        person.setFirstName("Frank");
        person.setLastName("van Beren");
        person.setTown("Frankfurt");
        person.setZip("464683");
        Example example = new Example();
        example.setPerson(person);
        example.setCompletedExample("Hallo ich bin Frank");
        return example;
    }

    public Example getCompletedExample2(Person person) {
        person.setCountry(new Locale("DE", "DEU"));
        person.setFirstName("Walter");
        person.setLastName("Weis");
        person.setTown("Berlin");
        person.setZip("6809098");
        Example example = new Example();
        example.setPerson(person);
        example.setCompletedExample("Hallo ich bin Walter");
        return example;
    }

    public List<Person> getListOfPersons(){
        List<Person> persons = new ArrayList<>();
        persons.add(getCompletedExample(new Person()).getPerson());
        persons.add(getCompletedExample2(new Person()).getPerson());
        return persons;
    }

}
