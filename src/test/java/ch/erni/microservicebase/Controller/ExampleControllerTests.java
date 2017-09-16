package ch.erni.microservicebase.Controller;

import ch.erni.microservicebase.Model.Example;
import ch.erni.microservicebase.Persistence.DAO.Person;
import ch.erni.microservicebase.Service.DataExampleService;
import ch.erni.microservicebase.Service.ExampleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by buma on 19.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleControllerTests {

    @Mock
    private ExampleService exampleService;

    @Mock
    DataExampleService dataExampleService;

    private ExampleController exampleController;

    @Before
    public void setUp() {
        exampleController = new ExampleController(dataExampleService ,exampleService);
    }


    @Test
    public void exampleController_returns_correct_message() {
        String testString = "Hallo ich bin Frank";
        Example testExample = new Example();
        testExample.setCompletedExample(testString);
        Mockito.when(exampleService.getCompletedExample(null)).thenReturn(testExample);

        Example testResult = exampleController.exampleController();

        assertThat(testResult.getCompletedExample()).isEqualTo("Hallo ich bin Frank");
    }

    @Test
    public void exampleController_returns_wrong_message() {
        String testString = "I am a completed example to trick you!";
        Example testExample = new Example();
        testExample.setCompletedExample(testString);
        Mockito.when(exampleService.getCompletedExample(null)).thenReturn(testExample);

        Example testResult = exampleController.exampleController();

        assertThat(testResult).isNotNull();
        assertThat(testResult.getCompletedExample()).isNotEqualTo("Hallo ich bin Frank");
    }
}
