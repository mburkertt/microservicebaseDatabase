package ch.erni.microservicedatabase.Persistence.Repository;

import ch.erni.microservicedatabase.Persistence.DAO.Person;
import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Locale;

import static ch.erni.microservicedatabase.Persistence.Repository.DataBaseObjectMotherIT.getDataSetFrank;
import static ch.erni.microservicedatabase.Persistence.Repository.DataBaseObjectMotherIT.getDataSetWalter;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Matthias on 16/09/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryIT {

    @Autowired
    private PersonRepository repository;

    @Test
    @DirtiesContext
    public void select_one_entry_from_db() {
        repository.deleteAll();
        repository.save(getDataSetFrank());

        Person result = repository.findOne(1L);

        assertThat(result).isNotNull();
        assertThat(result)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly("Frank", "van Beren", new Locale("DE", "DEU"), "Frankfurt");
        repository.deleteAll();
    }

    @Test
    @DirtiesContext
    public void select_all_entry_from_db() {
        repository.deleteAll();
        repository.save(getDataSetFrank());
        repository.save(getDataSetWalter());

        List<Person> result = repository.findAll();

        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly(Tuple.tuple("Frank", "van Beren", new Locale("DE", "DEU"), "Frankfurt"), Tuple.tuple("Walter", "Weis", new Locale("DE", "DEU"), "Berlin"));
    }

    @Test
    @DirtiesContext
    public void delete_one_entry_and_check_if_it_is_deleted() {
        repository.deleteAll();
        repository.save(getDataSetFrank());
        repository.save(getDataSetWalter());

        List<Person> result = repository.findAll();

        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly(Tuple.tuple("Frank", "van Beren", new Locale("DE", "DEU"), "Frankfurt"), Tuple.tuple("Walter", "Weis", new Locale("DE", "DEU"), "Berlin"));

        repository.delete(1L);

        List<Person> resultDeleted = repository.findAll();

        assertThat(resultDeleted).hasSize(1);
        assertThat(resultDeleted)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly(Tuple.tuple("Walter", "Weis", new Locale("DE", "DEU"), "Berlin"));
    }

    @Test
    @DirtiesContext
    public void delete_all_entry_and_check_if_it_is_deleted() {
        repository.deleteAll();
        repository.save(getDataSetFrank());
        repository.save(getDataSetWalter());

        List<Person> result = repository.findAll();

        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly(Tuple.tuple("Frank", "van Beren", new Locale("DE", "DEU"), "Frankfurt"), Tuple.tuple("Walter", "Weis", new Locale("DE", "DEU"), "Berlin"));

        repository.deleteAll();

        List<Person> resultDeleted = repository.findAll();

        assertThat(resultDeleted).hasSize(0);
    }
    
    @Test
    @DirtiesContext
    public void find_entry_by_lastname_find_weis_and_return_him() {
        repository.deleteAll();
        repository.save(getDataSetFrank());
        repository.save(getDataSetWalter());
        String lastName = "Weis";
        
        List<Person> result = repository.findByLastName(lastName);
        
        assertThat(result).hasSize(1);
        assertThat(result)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly(Tuple.tuple("Walter", "Weis", new Locale("DE", "DEU"), "Berlin"));
    }
    
    @Test
    @DirtiesContext
    public void find_entry_by_lastname_find_van_Beren_and_return_him() {
        repository.deleteAll();
        repository.save(getDataSetFrank());
        repository.save(getDataSetWalter());
        String lastName = "van Beren";
        
        List<Person> result = repository.findByLastName(lastName);
        
        assertThat(result).hasSize(1);
        assertThat(result)
                .extracting(Person::getFirstName, Person::getLastName, Person::getCountry, Person::getTown)
                .containsExactly(Tuple.tuple("Frank", "van Beren", new Locale("DE", "DEU"), "Frankfurt"));
    }
    
}
