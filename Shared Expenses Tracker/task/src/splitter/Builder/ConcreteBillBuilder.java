package splitter.Builder;

import splitter.Objects.Bill;
import splitter.Objects.Bills;
import splitter.Objects.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConcreteBillBuilder implements BillBuilder {

    private Bill bill;
    private final Bills bills;

    public ConcreteBillBuilder() {
        bill = new Bill();
        bills = Bills.getInstance();
    }
    @Override
    public void reset() {
       bill = new Bill();
    }

    @Override
    public void setFrom(Person person) {
        bill.setFrom(person);
    }

    @Override
    public void setTo(Person person) {
        bill.setTo(person);
    }

    @Override
    public void setAmount(Long amount) {
        bill.setAmount(amount);
    }

    @Override
    public void setDate(LocalDate date) {
        bill.setDate(date);
    }

    public Bill getResult(){
        bills.addBill(bill);
        return bill;
    }
}
