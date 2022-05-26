import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        assertTrue(ad.isEmpty());

        ad.addFirst(5);
        assertEquals(1, ad.size());

        ad.addFirst(4);
        ad.addFirst(3);

        int result = ad.get(2);
        Integer resultObject = ad.get(3);
        assertEquals(5, result);
        assertNull(resultObject);

        ad.addLast(7);
        ad.addLast(8);
        ad.addLast(9);
        ad.addLast(10);
        ad.addLast(11);
        assertEquals(8, ad.size());

        result = ad.removeFirst();
        assertEquals(3, result);
        assertEquals(7, ad.size());

        ad.addFirst(111);

        ad.addFirst(5);

        assertEquals(9, ad.size());
        ad.addLast(1111);
        ad.addLast(123);

        int result1 = ad.get(5);
        assertEquals(8, result1);

        ad.printDeque();

    }
}
