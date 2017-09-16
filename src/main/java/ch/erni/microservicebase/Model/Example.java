package ch.erni.microservicebase.Model;

import ch.erni.microservicebase.Persistence.DAO.Person;

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
