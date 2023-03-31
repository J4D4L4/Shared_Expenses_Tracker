package splitter.Commands;

import splitter.Objects.Bill;
import splitter.Objects.Person;
import splitter.Objects.Persons;
import splitter.Objects.Saldo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;

public class BalanceCommand extends Command{

    String option;
    public BalanceCommand() {
        super("balance");
    }

    @Override
    public void execute() {
        List<Bill> listBill;
        if (option.equals("close")){
            listBill = bills.getBeforeInc(date);
        }
        else {
            listBill = bills.getBeforeFirstDayOfMont(date);
        }
        List<Saldo> saldoList = getSaldoList(listBill);
        printSaldoList(saldoList);

    }

    @Override
    public boolean correctInput(String input) {
        String[] inputArray = input.split(" ");
        if(trySetDate(inputArray) && trySetOption(inputArray) && containsCommand(inputArray)){
            return true;
        }
        else
            return false;
    }

    public boolean containsCommand(String[] input){
        for(String inputS : input){
            if (inputS.equals("balance"))
                    return true;
        }
        return false;
    }

    public boolean trySetDate(String[] input){

        try {
            if(((input[input.length-1].equals("close") || input[input.length-1].equals("open")) && input.length>=3)
            || (!((input[input.length-1].equals("close") || input[input.length-1].equals("open"))) && input.length==2))
             {
                date = LocalDate.parse(input[0], formatter);
                return true;
            }
            else if( input.length == 1 || ((input[input.length-1].equals("close") || input[input.length-1].equals("open")) && input.length==2)){
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
        if(input[input.length-1].equals("close")||input[input.length-1].equals("open")){
            option = input[input.length-1];
            return true;
        }
        else if(date.equals(LocalDate.now()) && input.length == 1) {
            option = "close";
            return true;
        }
        else if(!date.equals(LocalDate.now()) && input.length == 2) {
            option = "close";
            return true;
        }
        else if(date.equals(LocalDate.now()) && input.length == 2) {
            option = input[1];
            return true;
        }
        else
            return false;
    }

    public void printSaldoList(List<Saldo> saldoList){
        Collections.sort(saldoList);
        if(saldoList.size() != 0) {
            for (Saldo saldo : saldoList) {
                System.out.printf("%s owes %s %s%n", saldo.getOws().getName(), saldo.getIsOwed().getName(), saldo.getAmount());
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
            if(newSaldo.getAmount() != new BigDecimal("0").setScale(2, RoundingMode.HALF_UP))
                saldoList.add(newSaldo);
        }
        return saldoList;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }
}
