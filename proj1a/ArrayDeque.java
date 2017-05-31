/**
 * Created by cyoste on 2017/05/24.
 */
public class ArrayDeque <Item> {

    Item[] array;
    private int size;

    /** TODO: figure out a better name for first and last */
    /** first points to the empty space before the first variable... consider it a transparent sentinel */
    private int first;
    /** last points to the empty space after the last variable... consider it a transparent sentinel */
    private int last;

    public ArrayDeque(){
        array = (Item[]) new Object[8];
        size = 0;
        first = 0;
        last = 1;
    }

    /** Adds an item to the front of the Deque. */
    public void addFirst(Item i){
        checkSize();
        array[first] = i;
        first = minusOne(first);
        size++;
    }

    /**  Adds an item to the back of the Deque. */
    public void addLast(Item i){
        checkSize();
        array[last] = i;
        last = plusOne(last);
        size++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns the number of items in the Deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque(){
        System.out.println("printing array: ");
        int printFirst = plusOne(first);
        for (int i = 0; i < size; i++) {
            System.out.println(array[printFirst]);
            printFirst = plusOne(printFirst);
        }
    }

    /** Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
    public Item removeFirst(){
        first = plusOne(first);
        Item i = array[first];
        array[first] = null;
        size--;
        checkSize();
        return i;
    }

    /** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
    public Item removeLast(){
        last = minusOne(last);
        Item i = array[last];
        array[last] = null;
        size--;
        checkSize();
        return i;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * */
    public Item get(int index){
        int arrayHead = plusOne(first);
        for (int i = 0; i < index; i++) {
            arrayHead = plusOne(arrayHead);
        }
        return array[arrayHead];
    }

    private void checkSize(){
        if (size == array.length){
            resizeUp();
        }
        if (size <= (array.length / 4) && array.length >= 16){
            resizeDown();
        }
    }

    private void resizeUp(){
        Item[] newArray = (Item[]) new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            first = plusOne(first);
            newArray[i] = array[first];
        }
        last = size;
        first = newArray.length - 1;
        array = newArray;
    }

    private void resizeDown(){
        Item[] newArray = (Item[]) new Object[array.length / 2];
        for (int i = 0; i < newArray.length; i++) {
            first = plusOne(first);
            newArray[i] = array[first];
        }
        last = size;
        first = newArray.length - 1;
        array = newArray;
    }

    private int minusOne(int edge){
        if (edge == 0){
            edge = array.length - 1;
        } else {
            edge--;
        }
        return edge;
    }

    private int plusOne(int edge){
        if (edge == array.length - 1){
            edge = 0;
        } else {
            edge++;
        }
        return edge;
    }



    public static void main(String args[]){
        ArrayDeque<String> myad = new ArrayDeque<>();
        myad.addFirst("z");
        myad.addFirst("y");
        myad.addFirst("x");
        myad.addFirst("w");
        myad.addFirst("v");
        myad.addFirst("u");



        myad.addLast("a");
        myad.addLast("b");
        myad.addLast("c");
        myad.addLast("d");
        myad.addLast("e");
        myad.addLast("f");
        myad.addLast("g");
        myad.addLast("h");
        myad.addLast("i");
        myad.addLast("j");
        myad.addLast("k");
        myad.addLast("l");
        myad.addLast("m");
        myad.addLast("o");
        myad.addLast("p");

        myad.printDeque();

        myad.removeFirst();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();
        myad.removeLast();


        myad.printDeque();
        System.out.println(myad.get(3));
    }
}
