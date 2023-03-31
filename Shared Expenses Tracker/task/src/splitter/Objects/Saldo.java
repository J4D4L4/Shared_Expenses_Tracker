package splitter.Objects;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Saldo implements Comparable<Saldo>{

    Person ows;
    Person isOwed;
    BigDecimal amount;

    public Saldo(Person ows, Person isOwed, BigDecimal amount){
        this.ows = ows;
        this.isOwed = isOwed;
        this.amount = amount;
    }

    public Person getOws() {
        return ows;
    }

    public void setOws(Person ows) {
        this.ows = ows;
    }

    public Person getIsOwed() {
        return isOwed;
    }

    public void setIsOwed(Person isOwed) {
        this.isOwed = isOwed;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Saldo calcSaldo(Person person1, Person person2){
        Bills bills = Bills.getInstance();
        Purchases purchases = Purchases.getInstance();
        float person1BillsSaldo = (float) bills.getBills().stream().filter(bill -> bill.getFrom().getName().equals(person1.getName()) && bill.getTo().getName().equals(person2.getName())).mapToDouble(bill -> bill.getAmount()).sum();
        float person2BillsSaldo = (float) bills.getBills().stream().filter(bill -> bill.getFrom().getName().equals(person2.getName()) && bill.getTo().getName().equals(person1.getName())).mapToDouble(bill -> bill.getAmount()).sum();
        if (person1BillsSaldo >= person2BillsSaldo){
            return new Saldo(person2,person1, new BigDecimal(person1BillsSaldo-person2BillsSaldo).setScale(2, RoundingMode.HALF_UP));
        }
        else {
            return new Saldo(person1,person2, new BigDecimal(person2BillsSaldo-person1BillsSaldo).setScale(2, RoundingMode.HALF_UP));
        }
    }

    @Override
    public int compareTo(Saldo otherSaldo) {
        if(this.ows.getName().compareTo(otherSaldo.ows.getName()) == 0) {
            return this.isOwed.getName().compareTo(otherSaldo.isOwed.getName());

        }
        else

        return this.ows.getName().compareTo(otherSaldo.ows.getName());
    }

}
