package splitter.Builder;

import splitter.Objects.Bill;
import splitter.Objects.Bills;
import splitter.Objects.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BillDirector {


    public void constructBill(BillBuilder builder, Person from, Person to, Long amount, LocalDate date){
        builder.reset();
        builder.setFrom(from);
        builder.setTo(to);
        builder.setAmount(amount);
        builder.setDate(date);


    }

}
