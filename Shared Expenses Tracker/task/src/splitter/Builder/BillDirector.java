package splitter.Builder;

import splitter.Objects.Person;

public class BillDirector {


    void constructBill(BillBuilder builder, Person from, Person to, Long amount){
        builder.reset();
        builder.setFrom(from);
        builder.setTo(to);
        builder.setAmount(amount);


    }

}
