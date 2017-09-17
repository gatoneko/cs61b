package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer <T> extends AbstractBoundedQueue <T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        rb =  (T[]) new Object[capacity];
        this.capacity = capacity;
        this.fillCount = 0;
        first = 0;
        last = 0;

    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        if (last >= rb.length) {
            last = 0;
        }
        rb[last] = x;
        last++;
        this.fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        if (first >= rb.length) {
            first = 0;
        }

        T t = rb[first];
//        rb[first] = null;
        first++;
        this.fillCount--;
        return t;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (first >= rb.length) {
            return rb[first - 1];
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    public Iterator<T> iterator(){
        return new myIterator(this);
    }

    private class myIterator implements Iterator<T> {
        ArrayRingBuffer<T> myARB;
        public myIterator(ArrayRingBuffer<T> a) {
            myARB = a;
        }

        public boolean hasNext(){
            if (!myARB.isEmpty()){
               return true;
            }
            return false;
        }

        public T next() {
            return myARB.dequeue();
        }
    }
}