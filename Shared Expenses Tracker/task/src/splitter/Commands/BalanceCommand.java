package splitter.Commands;

import splitter.Objects.Bill;
import splitter.Objects.Person;
import splitter.Objects.Persons;
import splitter.Objects.Saldo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class BalanceCommand extends Command{

    String option;
    protected BalanceCommand() {
        super("balance");
    }

    @Override
    public void execute() {
        List<Bill> listBill;
        if (option.equals("close")){
            listBill = bills.getBeforeInc(date);
        }
        else {
            listBill = bills.getBeforeExcl(date);
        }
        List<Saldo> saldoList = getSaldoList(listBill);
        printSaldoList(saldoList);

    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if(trySetDate(inputArray) && trySetOption(inputArray)){
            return true;
        }
        else
            return false;
    }

    public boolean trySetDate(String[] input){

        try {
            if(((input[input.length-1].equals("close") || input[input.length-1].equals("open")) && input.length>=3)
            || ((!input[input.length-1].equals("close") || !input[input.length-1].equals("open")) && input.length==2))
             {
                date = LocalDate.parse(input[0], formatter);
                return true;
            }
            else if( input.length == 1){
                date = LocalDate.now();
                return true;
            }
            else
                return false;
        }
        catch (Exception e){
            return false;
        }

    }

    public boolean trySetOption(String[] input){
        if(input[input.length-1].contains("close")||input[input.length-1].contains("open")){
            option = input[input.length-1];
            return true;
        }
        else if(date.equals(LocalDate.now()) && input.length == 1) {
            option = "close";
            return true;
        }
        else
            return false;
    }

    public void printSaldoList(List<Saldo> saldoList){
        if(saldoList.size() != 0) {
            for (Saldo saldo : saldoList) {
                System.out.printf("%s owes %s %d", saldo.getOws().getName(), saldo.getIsOwed().getName(), saldo.getAmount());
            }
        }
        else
            System.out.println("No repayments");
    }

    List<Saldo> getSaldoList(List<Bill> billList){
        List<Saldo> saldoList = new ArrayList<>();
        List<Person[]> personPairs = persons.getPersonPairs();
        for (Person[] personPair : personPairs){
            Saldo newSaldo = bills.calcSaldo(personPair[0], personPair[1],billList);
            if(newSaldo.getAmount() != 0L)
                saldoList.add(newSaldo);
        }
        return saldoList;
    }

}
