package Commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import splitter.Commands.BorrowCommand;
import splitter.Objects.Person;
import splitter.Objects.Persons;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BorrowCommandTest {

    BorrowCommand command;
    Persons persons;

    @BeforeEach
    void setUp() {
        command = new BorrowCommand();
        persons = Persons.getInstance();
    }

    @Test
    void testCorrectInput_validInput() {
        String input = "2022.04.01 borrow Alice Bob 100";
        assertTrue(command.correctInput(input));
    }

    @Test
    void testCorrectInput_missingInput() {
        String input = "borrow Alice Bob 100";
        assertTrue(command.correctInput(input));
    }

    @Test
    void testCorrectInput_invalidDate() {
        String input = "2022-04-01a borrow Alice Bob 100";
        assertFalse(command.correctInput(input));
    }

    @Test
    void testExecute_createsBill() {
        String input = "2022.04.01 borrow Bob Alice 100";
        command.correctInput(input);
        command.execute();
        LocalDate expectedDate = LocalDate.parse("2022.04.01", command.formatter);
        Person expectedFrom = persons.getOrCreatePerson("Alice");
        Person expectedTo = persons.getOrCreatePerson("Bob");
        assertEquals(expectedDate, command.getDate());
        assertEquals(expectedFrom, command.getFrom());
        assertEquals(expectedTo, command.getTo());
        assertEquals(100L, command.getAmount());
    }
}
