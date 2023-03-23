package Commands;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import splitter.Builder.BillDirector;
import splitter.Builder.ConcreteBillBuilder;
import splitter.Commands.BalanceCommand;
import splitter.Objects.Bill;
import splitter.Objects.Bills;
import splitter.Objects.Person;
import splitter.Objects.Persons;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestBalanceCommand {

    private BalanceCommand balanceCommand;
    private Persons persons;
    @Mock
    private Bill bill1;
    @Mock
    private Bill bill2;
    @Mock
    private Bill bill3;

    @BeforeEach
    void setUp() {
        balanceCommand = new BalanceCommand();
        persons = Persons.getInstance();
        persons.getPersons().clear();
        Person person1 = new Person("Alice");
        Person person2 = new Person("Bob");
        persons.addPerson(person1);
        persons.addPerson(person2);
        ConcreteBillBuilder builder = new ConcreteBillBuilder();
        BillDirector director = new BillDirector();
        director.constructBill(builder,person1,person2,20l,LocalDate.now());
        bill1 = builder.getResult();
        director.constructBill(builder,person2,person1,30l,LocalDate.now());
        bill2 = builder.getResult();
        director.constructBill(builder,person1,person2,10l,LocalDate.now().minusMonths(1));
        bill3 = builder.getResult();

        Bills.getInstance().getBills().clear();
        Bills.getInstance().addBill(bill1);
        Bills.getInstance().addBill(bill2);
        Bills.getInstance().addBill(bill3);
    }

    @Test
    void testCorrectInput_validInput_returnTrue() {
        String input = "2022.03.01 balance open";
        boolean result = balanceCommand.correctInput(input);
        assertEquals(true, result);
    }

    @Test
    void testCorrectInput_invalidDate_returnFalse() {
        String input = "2022.13.01 open";
        boolean result = balanceCommand.correctInput(input);
        assertEquals(false, result);
    }

    @Test
    void testCorrectInput_invalidOption_returnFalse() {
        String input = "2022.03.01 invalid";
        boolean result = balanceCommand.correctInput(input);
        assertEquals(false, result);
    }

    @Test
    void testExecute_openOption_printSaldoList() {
        balanceCommand.setDate(LocalDate.now().minusMonths(1));
        balanceCommand.setOption("close");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        balanceCommand.execute();

        String expectedOutput = String.format("Bob owes Alice 10%n");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecute_closeOption_printSaldoList() {
        balanceCommand.setDate(LocalDate.now());
        balanceCommand.setOption("close");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        balanceCommand.execute();

        String expectedOutput = String.format("No repayments%n");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecute_closeOption_noRepayments() {
        balanceCommand.setDate(LocalDate.now().minusMonths(1));
        balanceCommand.setOption("close");

        Bills.getInstance().getBills().remove(bill3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        balanceCommand.execute();

        String expectedOutput = String.format("No repayments%n");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testExecute_openOption_withRepayments() {
        // Arrange
        LocalDate date = LocalDate.of(2022, 3, 1);
        String[] inputArray = {"2022.03.01", "open"};

        BalanceCommand command = new BalanceCommand();
        command.bills.addBill(new Bill(command.persons.getOrCreatePerson("Jane"), command.persons.getOrCreatePerson("John"),  100l,date));
        command.bills.addBill(new Bill(command.persons.getOrCreatePerson("John"), command.persons.getOrCreatePerson("Jane"), 50l,date));
        command.bills.addBill(new Bill( command.persons.getOrCreatePerson("John"),command.persons.getOrCreatePerson("Mary"),20l, date));
        command.bills.addBill(new Bill( command.persons.getOrCreatePerson("Jane"), command.persons.getOrCreatePerson("Mary"),30l, date));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        command.setDate(date);
        command.setOption("close");
        // Act
        command.execute();

        // Assert
        String expectedOutput = String.format("John owes Jane 50%nMary owes Jane 30%nMary owes John 20%n");
        assertEquals(expectedOutput, outputStream.toString());
    }


}