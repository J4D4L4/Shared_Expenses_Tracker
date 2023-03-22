package splitter.Builder;

import splitter.Objects.Person;
import splitter.Objects.Persons;

public interface BillBuilder {
    void reset();
    void setFrom(Person person);
    void  setTo(Person person);
    void setAmount(Long amount);
}
