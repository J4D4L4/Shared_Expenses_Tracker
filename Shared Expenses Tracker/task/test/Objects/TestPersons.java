package Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import splitter.Objects.Person;
import splitter.Objects.Persons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TestPersons {

    private Persons persons;

    @BeforeEach
    void setUp() {
        persons = Persons.getInstance();
        persons.getPersons().clear();
    }

    @Test
    void testAddPerson() {
        Person personMock = mock(Person.class);
        persons.addPerson(personMock);
        assertEquals(1, persons.getPersons().size());
        assertEquals(personMock, persons.getPersons().get(0));
    }

    @Test
    void testRemovePerson() {
        Person personMock = mock(Person.class);
        persons.addPerson(personMock);
        persons.removePerson(personMock);
        assertEquals(0, persons.getPersons().size());

    }

    @Test
    void testNameExists() {
        Person personMock = new Person("test");
        persons.addPerson(personMock);
        assertEquals(true, persons.nameExists("test"));
    }
    @Test
    void testGetWithName() {
        Person personMock = new Person("test");
        persons.addPerson(personMock);
        assertEquals(personMock, persons.getWithName("test"));
    }
}
