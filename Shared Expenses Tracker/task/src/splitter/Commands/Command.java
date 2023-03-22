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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
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


}
