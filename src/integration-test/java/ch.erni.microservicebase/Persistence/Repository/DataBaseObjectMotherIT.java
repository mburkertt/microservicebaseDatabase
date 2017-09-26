package ch.erni.microservicebase.Persistence.Repository;
import ch.erni.microservicebase.Persistence.DAO.Person;

import java.util.Locale;

/**
 * Created by Matthias on 16/09/2017.
 */
public final class DataBaseObjectMotherIT {

    public static Person getDataSetFrank() {
        Person person = new Person();
        person.setCountry(new Locale("DE", "DEU"));
        person.setFirstName("Frank");
        person.setLastName("van Beren");
        person.setTown("Frankfurt");
        person.setZip("464683");
        return person;
    }


    public static Person getDataSetWalter() {
        Person person = new Person();
        person.setCountry(new Locale("DE", "DEU"));
        person.setFirstName("Walter");
        person.setLastName("Weis");
        person.setTown("Berlin");
        person.setZip("6809098");
        return person;
    }
}
