package ch.erni.microservicedatabase.Model;

import ch.erni.microservicedatabase.Persistence.DAO.Person;

/**
 * Created by buma on 19.01.2017.
 */
public class Example {

    private String completedExample;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public final String getCompletedExample() {
        return completedExample;
    }

    public final void setCompletedExample(String completedExample) {
        this.completedExample = completedExample;
    }
}
