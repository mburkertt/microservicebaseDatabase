package ch.erni.microservicebase.Service;

import ch.erni.microservicebase.Persistence.DAO.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by buma on 19.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceTests {


    private ExampleService exampleService = new ExampleService();

    @Test
    public void getCompletedExample_with_correct_input_string_must_deliver_correct_output_message() {
        String testString = "Hallo ich bin Frank";
        assertThat(exampleService.getCompletedExample(new Person()).getCompletedExample()).isEqualTo(testString);
    }

    @Test
    public void getCompletedExample_with_incorrect_input_string_must_deliver_correct_output_message() {
        String testString = "Hallo ich bin Walter";
        assertThat(exampleService.getCompletedExample(new Person()).getCompletedExample()).isNotEqualTo(testString);
    }
}
