package Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import splitter.Objects.Bill;
import splitter.Objects.Bills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TestBills {

    private Bills bills;

    @BeforeEach
    void setUp() {
        bills = Bills.getInstance();
        bills.getBills().clear();
    }

    @Test
    void testAddBill() {
        Bill billMock = mock(Bill.class);
        bills.addBill(billMock);
        assertEquals(1, bills.getBills().size());
        assertEquals(billMock, bills.getBills().get(0));
    }

    @Test
    void testRemoveBill() {
        Bill billMock = mock(Bill.class);
        bills.addBill(billMock);
        bills.removeBill(billMock);
        assertEquals(0, bills.getBills().size());
;
    }

}
