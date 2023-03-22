package Objects;

import org.junit.jupiter.api.Test;
import splitter.Objects.Bill;
import splitter.Objects.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestBill {

    @Test
    void testGetFrom() {
        Person personMock = mock(Person.class);
        Bill bill = new Bill();
        bill.setFrom(personMock);
        assertEquals(personMock, bill.getFrom());
    }

    @Test
    void testGetTo() {
        Person personMock = mock(Person.class);
        Bill bill = new Bill();
        bill.setTo(personMock);
        assertEquals(personMock, bill.getTo());
    }

    @Test
    void testGetAmount() {
        Long expectedAmount = 100L;
        Bill bill = new Bill();
        bill.setAmount(expectedAmount);
        assertEquals(expectedAmount, bill.getAmount());
    }

    @Test
    void testSetFrom() {
        Person personMock = mock(Person.class);
        Bill bill = new Bill();
        bill.setFrom(personMock);
        assertEquals(personMock, bill.getFrom());
    }

    @Test
    void testSetTo() {
        Person personMock = mock(Person.class);
        Bill bill = new Bill();
        bill.setTo(personMock);
        assertEquals(personMock, bill.getTo());
    }

    @Test
    void testSetAmount() {
        Long expectedAmount = 100L;
        Bill bill = new Bill();
        bill.setAmount(expectedAmount);
        assertEquals(expectedAmount, bill.getAmount());
    }

    @Test
    void testGetSetFromWithMock() {
        Person personMock = mock(Person.class);
        Bill billMock = mock(Bill.class);
        when(billMock.getFrom()).thenReturn(personMock);
        billMock.setFrom(personMock);
        assertEquals(personMock, billMock.getFrom());
    }

    @Test
    void testGetSetToWithMock() {
        Person personMock = mock(Person.class);
        Bill billMock = mock(Bill.class);
        when(billMock.getTo()).thenReturn(personMock);
        billMock.setTo(personMock);
        assertEquals(personMock, billMock.getTo());
    }

    @Test
    void testGetSetAmountWithMock() {
        Long expectedAmount = 100L;
        Bill billMock = mock(Bill.class);
        when(billMock.getAmount()).thenReturn(expectedAmount);
        billMock.setAmount(expectedAmount);
        assertEquals(expectedAmount, billMock.getAmount());
    }
}
