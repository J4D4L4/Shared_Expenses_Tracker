package splitter.Builder;

import splitter.Objects.Bill;
import splitter.Objects.Person;

public class ConcreteBillBuilder implements BillBuilder {

    Bill bill;
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

    public Bill getResult(){
        return bill;
    }
}
