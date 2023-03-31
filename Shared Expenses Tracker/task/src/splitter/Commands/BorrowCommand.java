package splitter.Commands;

import splitter.Builder.BillDirector;
import splitter.Builder.ConcreteBillBuilder;
import splitter.Objects.Bill;
import splitter.Objects.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowCommand extends Command{
    float amount;
    Person from;
    Person to;


    public BorrowCommand() {
        super("borrow");
    }

    @Override
    public void execute() {
        ConcreteBillBuilder billBuilder = new ConcreteBillBuilder();
        BillDirector director = new BillDirector();
        director.constructBill(billBuilder,  from, to, amount, date);
        Bill bill = billBuilder.getResult();


    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if(inputLength(inputArray)&& trySetDate(inputArray) && trySetAmt(inputArray)) {
            setPersons(inputArray);
            return true;
        }
        else
            return false;
    }

    public boolean inputLength(String[] input){


        if(input.length>=4 ) {

            setPersons(input);
            return true;
        }
        else
            return false;
    }

    public boolean trySetDate(String[] input){

        if(input.length==5) {
            try {
                date = LocalDate.parse(input[0], formatter);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }

        else {
            date = LocalDate.now();
            return true;
        }

    }

    boolean trySetAmt(String[] input){
        try{
            if(input.length==4) {
                amount = Float.parseFloat(input[3]);
                return true;
            }
            else if(input.length == 5) {
                amount = Float.parseFloat(input[4]);
                return true;
            }

            return false;
        }
        catch (Exception e){
            return false;
        }
    }

    public void setPersons(String[] input){
        if(input.length == 5){
            from = persons.getOrCreatePerson(input[3]);
            to = persons.getOrCreatePerson(input[2]);
        }
        else {
            from = persons.getOrCreatePerson(input[2]);
            to = persons.getOrCreatePerson(input[1]);
        }
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getDate(){
        return date;
    }
    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }
}

