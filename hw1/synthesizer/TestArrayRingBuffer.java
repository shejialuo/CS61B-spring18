package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void initializationTest() {
        ArrayRingBuffer<Integer> arrayRingBuffer = new  ArrayRingBuffer<Integer>(10);
        assertTrue(arrayRingBuffer.isEmpty());
        assertFalse(arrayRingBuffer.isFull());
        assertEquals(10, arrayRingBuffer.capacity());
    }

    @Test
    public void basicFunctionalityTest() {
        ArrayRingBuffer<Integer> arrayRingBuffer = new  ArrayRingBuffer<Integer>(10);

        arrayRingBuffer.enqueue(5);
        assertFalse(arrayRingBuffer.isEmpty());
        int num = arrayRingBuffer.peek();
        assertEquals(5, num);

        for (int i = 0; i < 9; i++) {
            arrayRingBuffer.enqueue(i);
        }

        assertTrue(arrayRingBuffer.isFull());
        num = arrayRingBuffer.dequeue();
        assertEquals(5, num);
        for (int i = 0; i < 9; i++) {
            num = arrayRingBuffer.dequeue();
            assertEquals(i, num);
        }
        assertTrue(arrayRingBuffer.isEmpty());
    }

    @Test
    public void cornerTest() {
        ArrayRingBuffer<Integer> arrayRingBuffer = new  ArrayRingBuffer<Integer>(2);
        arrayRingBuffer.enqueue(5);
        arrayRingBuffer.enqueue(4);
        int num = arrayRingBuffer.dequeue();
        assertEquals(5, num);

        arrayRingBuffer.enqueue(3);
        num = arrayRingBuffer.peek();
        assertEquals(4, num);

        arrayRingBuffer.dequeue();
        num = arrayRingBuffer.peek();
        assertEquals(3, num);

        assertEquals(1, arrayRingBuffer.fillCount());
        arrayRingBuffer.enqueue(101);

        arrayRingBuffer.dequeue();
        num = arrayRingBuffer.peek();
        assertEquals(101, num);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
