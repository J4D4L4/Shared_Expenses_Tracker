package splitter.Commands;

import splitter.Objects.Bill;
import splitter.Objects.Bills;
import splitter.Objects.Person;
import splitter.Objects.Persons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public abstract class Command {

    public String inputString;
    public Persons persons;
    public Bills bills;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate date;
    Person from;
    Person to;

    protected Command(String inputString)  {
        this.inputString = inputString;
        this.persons = Persons.getInstance();
        this.bills = Bills.getInstance();

    }

    public abstract void execute();
    public abstract boolean correctInput(String input);

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getInputString() {
        return inputString;
    }

    public Persons getPersons() {
        return persons;
    }

    public Bills getBills() {
        return bills;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public LocalDate getDate() {
        return date;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }
}
