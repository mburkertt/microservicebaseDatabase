package ch.erni.microservicedatabase.Persistence.DAO;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by Matthias on 11/09/2017.
 */
@Entity
@Table(name = "\"person\"")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "\"firstName\"")
    private String firstName;
    @Column(name = "\"lastName\"")
    private String lastName;
    @Column(name = "\"town\"")
    private String town;
    @Column(name = "\"country\"")
    private Locale country;
    @Column(name = "\"zip\"")
    private String zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
