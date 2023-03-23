package splitter.Objects;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Person {
    String id;
    String name;
    List<Bill> bills;

    public Person(String name){

        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.bills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBill(Bill bill){
        bills.add(bill);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public String getId() {
        return id;
    }


}
