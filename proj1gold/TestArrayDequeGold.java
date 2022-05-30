import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void randomizedTest() {
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();

        String message = "";

        while (true) {
            int select = StdRandom.uniform(4);
            int number = StdRandom.uniform(100);
            if (select == 0) {
                solution.addFirst(number);
                student.addFirst(number);
                message = message.concat("addFirst(")
                                 .concat(String.valueOf(number))
                                 .concat(")\n");
            } else if (select == 1) {
                solution.addLast(number);
                student.addLast(number);
                message = message.concat("addLast(")
                                 .concat(String.valueOf(number))
                                 .concat(")\n");
            } else if (select == 2) {
                if (!solution.isEmpty()) {
                    Integer expected = solution.removeFirst();
                    Integer actual = student.removeFirst();
                    message = message.concat("removeFirst()\n");
                    assertEquals(message, expected, actual);
                }
            } else {
                if (!solution.isEmpty()) {
                    Integer expected = solution.removeLast();
                    Integer actual = student.removeLast();
                    message = message.concat("removeLast()\n");
                    assertEquals(message, expected, actual);
                }
            }
        }
    }
}
