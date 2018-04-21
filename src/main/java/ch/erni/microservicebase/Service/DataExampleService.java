package ch.erni.microservicebase.Service;

import ch.erni.microservicebase.Persistence.DAO.Person;

import java.util.Collection;
import java.util.List;

public interface DataExampleService {


    void savePerson(Person person);

    Person findPerson(long id);

    void deletePerson(long id);

    List<Person> findAllPersons();

    void saveAllPersons(Collection<Person> persons);

    void deleteAllPersons();
}
