package splitter.Objects;

import java.util.ArrayList;
import java.util.List;

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

}
