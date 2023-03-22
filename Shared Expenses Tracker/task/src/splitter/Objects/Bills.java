package splitter.Objects;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bills {

    static Bills instance;
    List<Bill> bills;
    private Bills(){
        bills = new ArrayList<>();
    }

    public static Bills getInstance(){
        if(instance == null){
            instance = new Bills();
        }
        return instance;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public List<Bill> getBeforeInc(LocalDate date){
        return bills.stream().filter(bill -> bill.date.isBefore(date) || bill.date.equals(date)).collect(Collectors.toList());

    }
    public List<Bill> getBeforeFirstDayOfMont(LocalDate date){
        return bills.stream().filter(bill -> bill.date.isBefore(date.withDayOfMonth( 1 ))).collect(Collectors.toList());
    }
    public Saldo calcSaldo(Person person1, Person person2, List<Bill> billList){
        Long person1Saldo = billList.stream().filter(bill -> bill.getFrom().name.equals(person1.name) && bill.getTo().getName().equals(person2.name)).mapToLong(bill -> bill.getAmount()).sum();
        Long person2Saldo = billList.stream().filter(bill -> bill.getFrom().name.equals(person2.name) && bill.getTo().getName().equals(person1.name)).mapToLong(bill -> bill.getAmount()).sum();
        if (person1Saldo >= person2Saldo){
            return new Saldo(person2,person1, person1Saldo-person2Saldo);
        }
        else {
            return new Saldo(person1,person2, person2Saldo-person1Saldo);
        }
    }

}
