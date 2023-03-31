package splitter.Objects;

import splitter.Builder.BillDirector;
import splitter.Builder.ConcreteBillBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Purchase {
    Group group;
    Person purchasedBy;
    float amount;
    String name;
    LocalDate date;
    Bills bills = Bills.getInstance();
    int purchaseByAmtOfPeople;
    BigDecimal overCharge;


    public Purchase(String name, Group group, Person purchasedBy, Float amount, LocalDate date){
        this.group = group;
        this.purchasedBy = purchasedBy;
        this.amount = amount;
        this.name = name;
        this.date = date;
        setPurchasedByAmtOfPeople();
        createBills();
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Person getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(Person purchasedBy) {
        this.purchasedBy = purchasedBy;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }



    public void createBills(){

       Boolean purchasedByPartOfGroup = false;
       BigDecimal perPerson = new BigDecimal(amount)
               .divide(new BigDecimal(purchaseByAmtOfPeople),2, RoundingMode.DOWN)
               .setScale(2, RoundingMode.HALF_UP);
       overCharge = new BigDecimal(amount).subtract(perPerson.multiply(new BigDecimal(purchaseByAmtOfPeople))).setScale( 2, RoundingMode.HALF_UP);
       for(Person person : group.getMembers()){
           if(person != purchasedBy){
               createBillForPerson(person, perPerson);
           }
       }
    }

    public void createBillForPerson(Person purchasedFor, BigDecimal perPresonAmt){
        ConcreteBillBuilder billBuilder = new ConcreteBillBuilder();
        BillDirector director = new BillDirector();
        BigDecimal overchargeAdder = getOverchargeAdder(overCharge);
        if(overCharge.compareTo(BigDecimal.ZERO)!=0){
            director.constructBill(billBuilder, purchasedBy,purchasedFor,perPresonAmt.add(overchargeAdder).floatValue(), date);
            overCharge = (overCharge.add(overchargeAdder.multiply(new BigDecimal(-1))));
        }
        else {
            director.constructBill(billBuilder, purchasedBy,purchasedFor,perPresonAmt.floatValue(), date);
        }
        billBuilder.getResult();
    }

    BigDecimal getOverchargeAdder(BigDecimal overCharege){
        if(overCharege.compareTo(BigDecimal.ZERO)>0)
            return new BigDecimal("0.01");
        else
            return new BigDecimal("-0.01");
    }

    public void setPurchasedByAmtOfPeople(){
        if(group.namePartOfGroup(purchasedBy.name)){
            purchaseByAmtOfPeople = group.getMembers().size();
        }
        else
            purchaseByAmtOfPeople = group.getMembers().size();
    }
}
