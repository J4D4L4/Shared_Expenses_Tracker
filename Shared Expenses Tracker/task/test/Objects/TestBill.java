package Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import splitter.Objects.Bill;
import splitter.Objects.Person;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class TestBill {

    @Mock
    Person mockPerson;

    private Bill bill;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bill = new Bill();
    }

    @Test
    void testGetFrom() {
        bill.setFrom(mockPerson);
        assertEquals(mockPerson, bill.getFrom());
    }

    @Test
    void testSetFrom() {
        bill.setFrom(mockPerson);
        verify(mockPerson).addBill(bill);
    }

    @Test
    void testGetTo() {
        bill.setTo(mockPerson);
        assertEquals(mockPerson, bill.getTo());
    }

    @Test
    void testSetTo() {
        bill.setTo(mockPerson);
        verify(mockPerson).addBill(bill);
    }

    @Test
    void testGetAmount() {
        bill.setAmount(100L);
        assertEquals(100L, bill.getAmount());
    }

    @Test
    void testSetAmount() {
        bill.setAmount(100L);
        assertEquals(100L, bill.getAmount());
    }

    @Test
    void testGetId() {
        assertEquals(String.class, bill.getId().getClass());
    }

    @Test
    void testGetDate() {
        LocalDate now = LocalDate.now();
        bill.setDate(now);
        assertEquals(now, bill.getDate());
    }

    @Test
    void testSetDate() {
        LocalDate now = LocalDate.now();
        bill.setDate(now);
        assertEquals(now, bill.getDate());
    }
}