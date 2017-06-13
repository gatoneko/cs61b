/**
 * Created by cyoste on 2017/06/06.
 *
 * Tests StudentArrayDeque to ArrayDequeSolution
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    private StudentArrayDeque<Integer> student;
    private ArrayDequeSolution<Integer> solution;
    private OperationSequence sequence;


    /** Randomly calls methods until there is a discrepancy */
    /**
     * TODO: 2017/06/12 Since we're going to be adding "DequeOperation" objects and putting them to the sequence,
     * we need to put every operation into a helper method. eg addLast, addFirst
     */
    @Test
    public void randomMethodTest() {
        solution = new ArrayDequeSolution<>();
        student = new StudentArrayDeque<>();
        sequence = new OperationSequence();

        for (int i = 0; i < 10000; i++) {
            Integer randomVal = StdRandom.uniform(99);
            double switchVal = StdRandom.uniform();

            if (switchVal <= 0.25) {
                addLast(randomVal);
            } else if (switchVal <= .50) {
                addFirst(randomVal);
            } else if (switchVal <= .75) {
                if (solution.size() > 0) {
                    removeLast();
                }
            } else {
                if (solution.size() > 0) {
                    removeFirst();
                }
            }
        }
    }


    private void addLast(Integer randomVal) {
        student.addLast(randomVal);
        solution.addLast(randomVal);
        DequeOperation op = new DequeOperation("addLast", randomVal);
        sequence.addOperation(op);
    }

    private void addFirst(Integer randomVal) {
        student.addFirst(randomVal);
        solution.addFirst(randomVal);
        DequeOperation op = new DequeOperation("addFirst", randomVal);
        sequence.addOperation(op);
    }

    private void removeLast() {
        Integer a = student.removeLast();
        Integer b = solution.removeLast();
        DequeOperation op = new DequeOperation("removeLast");
        sequence.addOperation(op);
        assertEquals(sequence.toString(), a, b);
    }

    private void removeFirst() {
        Integer a = student.removeFirst();
        Integer b = solution.removeFirst();
        DequeOperation op = new DequeOperation("removeFirst");
        sequence.addOperation(op);
        assertEquals(sequence.toString(), a, b);
    }
}