package splitter.Objects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Collections;
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

        Collections.sort(bills);
        return bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
    }

    public List<Bill> getBeforeInc(LocalDate date){
        return bills.stream().filter(bill -> bill.getDate().isBefore(date) || bill.getDate().isEqual(date)).collect(Collectors.toList());

    }
    public List<Bill> getBeforeFirstDayOfMont(LocalDate date){
        return bills.stream().filter(bill -> bill.getDate().isBefore(date.withDayOfMonth( 1 ))).collect(Collectors.toList());
    }
    public Saldo calcSaldo(Person person1, Person person2, List<Bill> billList){
        float person1Saldo = (float) billList.stream().filter(bill -> bill.getFrom().getName().equals(person1.getName()) && bill.getTo().getName().equals(person2.getName())).mapToDouble(bill -> bill.getAmount()).sum();
        float person2Saldo = (float) billList.stream().filter(bill -> bill.getFrom().getName().equals(person2.getName()) && bill.getTo().getName().equals(person1.getName())).mapToDouble(bill -> bill.getAmount()).sum();
        if (person1Saldo >= person2Saldo){
            return new Saldo(person2,person1, new BigDecimal(person1Saldo-person2Saldo).setScale(2, RoundingMode.HALF_UP));
        }
        else {
            return new Saldo(person1,person2, new BigDecimal(person2Saldo-person1Saldo).setScale(2, RoundingMode.HALF_UP));
        }
    }

    public void clearList(){
        bills = new ArrayList<>();
    }

}
