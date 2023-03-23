package splitter.Commands;

import splitter.Builder.BillDirector;
import splitter.Builder.ConcreteBillBuilder;
import splitter.Objects.Bill;

import java.time.LocalDate;

public class RepayCommand extends Command{
    Long amount;
    protected RepayCommand( ) {
        super("repay");
    }

    @Override
    public void execute() {
        ConcreteBillBuilder billBuilder = new ConcreteBillBuilder();
        BillDirector director = new BillDirector();
        director.constructBill(billBuilder,  from, to,  amount, date);
        Bill bill = billBuilder.getResult();
    }

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
                amount = Long.parseLong(input[3]);
                return true;
            }
            else if(input.length == 5) {
                amount = Long.parseLong(input[4]);
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
            from = persons.getOrCreatePerson(input[2]);
            to = persons.getOrCreatePerson(input[3]);
        }
        else {
            from = persons.getOrCreatePerson(input[1]);
            to = persons.getOrCreatePerson(input[2]);
        }
    }
}
