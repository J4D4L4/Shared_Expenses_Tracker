package Objects;

import org.junit.Test;
import splitter.Objects.Person;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestPerson {

    @Test
    public void testGetName() {
        String expectedName = "John";
        Person person = new Person(expectedName);
        assertEquals(expectedName, person.getName());
    }

    @Test
    public void testSetName() {
        String expectedName = "John";
        Person person = new Person("");
        person.setName(expectedName);
        assertEquals(expectedName, person.getName());
    }

    @Test
    public void testSetNameWithMock() {
        String expectedName = "John";
        Person personMock = mock(Person.class);
        when(personMock.getName()).thenReturn(expectedName);
        personMock.setName(expectedName);
        assertEquals(expectedName, personMock.getName());
    }
}
