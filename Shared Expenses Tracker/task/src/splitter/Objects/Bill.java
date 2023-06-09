package splitter.Objects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Bill {

    private String id;
    LocalDate date;
    Person from;
    Person to;
    Long amount;

    public Bill(){
        this.id = UUID.randomUUID().toString();
    }

    public Bill(Person from, Person to, Long amount, LocalDate date){

        this.id = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {

        this.from = from;
        from.addBill(this);
    }

    public Person getTo() {
        return to;
    }

    public void setTo(Person to) {
        this.to = to;
        to.addBill(this);
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
