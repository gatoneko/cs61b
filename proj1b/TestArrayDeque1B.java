/**
 * Created by cyoste on 2017/06/06.
 *
 * Tests StudentArrayDeque to ArrayDequeSolution
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    /** Randomly calls methods until there is a discrepancy */
    // TODO: 2017/06/06  Make this method which is required by the project.
    @Test
    public void randomMethodTest() {
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();

        for (int i = 0 ; i < 10000; i++) {
            Integer randomVal = StdRandom.uniform(99);
            double switchVal = StdRandom.uniform();

            if (switchVal <= 0.25) {
                student.addLast(randomVal);
                solution.addLast(randomVal);
            } else if (switchVal <= .50) {
                student.addFirst(randomVal);
                solution.addFirst(randomVal);
            } else if (switchVal <= .75) {
                if (student.size() > 0) {
                   Integer a = student.removeLast();
                   Integer b = solution.removeLast();
                   assertEquals(a, b);
                }
            } else {
                if (student.size() > 0) {
                    Integer a = student.removeFirst();
                    Integer b = solution.removeFirst();
                    assertEquals(a, b);
                }
            }
        }
    }
}
