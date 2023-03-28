package splitter.Objects;

public class Purchase {
    Group group;
    Person purchasedBy;
    Long amount;
    String name;


    public Purchase(String name, Group group, Person purchasedBy, Long amount){
        this.group = group;
        this.purchasedBy = purchasedBy;
        this.amount = amount;
        this.name = name;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
