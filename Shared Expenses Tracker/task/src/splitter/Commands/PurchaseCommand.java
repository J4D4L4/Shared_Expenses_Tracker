package splitter.Commands;

import splitter.Objects.*;
import splitter.RegExHelper;

import java.time.LocalDate;

public class PurchaseCommand extends Command{

    Long amount;
    Groups groups;
    Persons persons;
    Purchases purchases;
    Group group;
    Person from;
    String name;
    protected PurchaseCommand( ) {

        super("purchase");
        groups = Groups.getInstance();
        persons = Persons.getInstance();
        purchases = Purchases.getInstance();
    }

    @Override
    public void execute() {
        setFrom(userInput);
        setName(userInput);
        Purchase purchase = new Purchase(name, group, from, amount);
        purchases.addPurchse(purchase);

    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if(trySetDate(inputArray)
                && trySetAmt(inputArray)
                && groupExistsAndSet(inputArray)){
            return true;

        }
        return false;
    }

    public boolean trySetDate(String[] input){
        if(RegExHelper.isDate(input[0])){
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
            if(this.date.equals(LocalDate.now())) {
                amount = Long.parseLong(input[3]);
                return true;
            }
            else  {
                amount = Long.parseLong(input[4]);
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    boolean groupExistsAndSet(String[] input){
        String groupName;
        if(this.date.equals(LocalDate.now())){
            groupName = input[4].replace("(", "").replace(")","");
            if (groups.nameExists(groupName)){
                group = groups.getByName(groupName);
                return true;
            }
        }
        else if(date != null){
            groupName = input[3].replace("(", "").replace(")","");
            if (groups.nameExists(groupName)){
                group = groups.getByName(groupName);
                return true;
            }
        }

        return false;
    }
    public void setFrom(String[] input){
        if(date.equals(LocalDate.now())){
            from = persons.getOrCreatePerson(input[1]);
        }
        else
            from = persons.getOrCreatePerson(input[2]);
    }
    public void  setName(String[] input){
        if(date.equals(LocalDate.now())){
            this.name = (input[2]);
        }
        else
            this.name = (input[3]);
    }
}
