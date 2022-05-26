import static org.junit.Assert.*;
import org.junit.Test;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

	@Test
	public void addRemoveTest() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		assertTrue(lld1.isEmpty());

		lld1.addFirst(5);
		assertFalse(lld1.isEmpty());

		lld1.addFirst(4);
		assertEquals(2, lld1.size());
		int front1 = lld1.get(0);
		int front2 = lld1.get(1);
		Integer frontNull = lld1.get(2);
		assertEquals(4, front1);
		assertEquals(5, front2);
		assertNull(frontNull);

		lld1.addLast(12);
		lld1.removeFirst();
		assertEquals(2, lld1.size());
		front1 = lld1.get(0);
		front2 = lld1.getRecursive(1);
		int end = lld1.get(1);
		assertEquals(5, front1);
		assertEquals(12, front2);
		assertEquals(12, end);
		assertEquals(2,lld1.size());
	}
}
