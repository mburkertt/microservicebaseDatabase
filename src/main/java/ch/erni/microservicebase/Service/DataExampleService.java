package ch.erni.microservicebase.Service;

import ch.erni.microservicebase.Persistence.DAO.Person;
import ch.erni.microservicebase.Persistence.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Matthias on 14/09/2017.
 */
@Service
@Transactional
public class DataExampleService {

    private PersonRepository repository;

    @Autowired
    public DataExampleService(PersonRepository repository) {
        this.repository = repository;
    }

    public void savePerson(Person person) {
        repository.save(person);
    }

    public Person findPerson(long id) {
        return repository.findOne(id);
    }

    public void deletePerson(long id) {
        repository.delete(id);
    }

    public List<Person> findAllPersons() {
        return repository.findAll();
    }

    public void saveAllPersons(Collection<Person> persons) {
        repository.save(persons);
    }

    public void deleteAllPersons() {
        repository.deleteAll();
    }

}
