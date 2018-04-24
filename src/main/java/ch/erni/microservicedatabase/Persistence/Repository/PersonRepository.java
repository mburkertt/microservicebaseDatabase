package ch.erni.microservicedatabase.Persistence.Repository;

import ch.erni.microservicedatabase.Persistence.DAO.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Matthias on 13/09/2017.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByLastName(String lastName);
}
