package splitter.Objects;

public class Saldo {

    Person ows;
    Person isOwed;
    Long amount;

    Saldo(Person ows, Person isOwed, Long amount){
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
