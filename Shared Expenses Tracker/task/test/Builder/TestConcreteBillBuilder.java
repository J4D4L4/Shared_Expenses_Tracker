package Builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import splitter.Builder.ConcreteBillBuilder;
import splitter.Objects.Bill;
import splitter.Objects.Bills;
import splitter.Objects.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TestConcreteBillBuilder {

    private ConcreteBillBuilder builder;
    private Bills bills;

    @BeforeEach
    void setUp() {
        builder = new ConcreteBillBuilder();
        builder.reset();
        bills = Bills.getInstance();
        bills.getBills().clear();
    }

    @Test
    void testSetFrom() {
        Person personMock = mock(Person.class);
        builder.setFrom(personMock);
        Bill bill = builder.getResult();
        assertEquals(personMock, bill.getFrom());
    }

    @Test
    void testSetTo() {
        Person personMock = mock(Person.class);
        builder.setTo(personMock);
        Bill bill = builder.getResult();
        assertEquals(personMock, bill.getTo());
    }

    @Test
    void testSetAmount() {
        Long expectedAmount = 100L;
        builder.setAmount(expectedAmount);
        Bill bill = builder.getResult();
        assertEquals(expectedAmount, bill.getAmount());
    }

    @Test
    void testReset() {
        builder.setAmount(100L);
        builder.reset();
        Bill bill = builder.getResult();
        assertEquals(null, bill.getFrom());
        assertEquals(null, bill.getTo());
        assertEquals(null, bill.getAmount());
    }

    @Test
    void testGetResult() {
        Person personMock = mock(Person.class);
        Long expectedAmount = 100L;
        builder.setFrom(personMock);
        builder.setTo(personMock);
        builder.setAmount(expectedAmount);
        Bill bill = builder.getResult();
        assertEquals(1, bills.getBills().size());
        assertEquals(bill, bills.getBills().get(0));
        assertEquals(personMock, bill.getFrom());
        assertEquals(personMock, bill.getTo());
        assertEquals(expectedAmount, bill.getAmount());
    }

}