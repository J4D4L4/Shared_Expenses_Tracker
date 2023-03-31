package splitter.Builder;

import splitter.Objects.Person;
import splitter.Objects.Persons;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface BillBuilder {
    void reset();
    void setFrom(Person person);
    void  setTo(Person person);
    void setAmount(float amount);
    void  setDate(LocalDate date);
}
