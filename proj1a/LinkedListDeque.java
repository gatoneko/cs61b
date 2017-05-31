/**
 * Created by cyoste on 2017/05/23.
 */
public class LinkedListDeque <Item> {

    public class ListNode {
        Item item;
        ListNode prev;
        ListNode next;

        public ListNode(Item i, ListNode p, ListNode n){
            item = i;
            prev = p;
            next = n;
        }

        public String toString(){
            return "name: " + item + "\n" +
                    "prev: " + prev.item + "\n" +
                     "next: " + next.item + "\n";
        }
    }

    private int size;
    private ListNode sentinel;

    public LinkedListDeque(){
        /** Making a sentinel node*/
        sentinel = new ListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Adds an item to the front of the Deque. */
    public void addFirst(Item i){
        ListNode addedNode = new ListNode(i, sentinel, sentinel.next);
        sentinel.next.prev = addedNode;
        sentinel.next = addedNode;
        size++;
    }

    /**  Adds an item to the back of the Deque. */
    public void addLast(Item i){
        ListNode addedNode = new ListNode(i, sentinel.prev, sentinel);
        sentinel.prev.next = addedNode;
        sentinel.prev = addedNode;
        size++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        } else{
            return false;
        }
    }

    /** Returns the number of items in the Deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque(){
        ListNode counter = sentinel.next;
        for (int i = 1; i < size; i++){ // i is 1 because we're skipping the sentinel, right?
            System.out.println(counter);
            counter = counter.next;
        }
    }

    /** Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
    public Item removeFirst(){
        if (sentinel.next == sentinel){
            return null;
        }
        ListNode toRemove = sentinel.next;
        sentinel.next = toRemove.next;
        toRemove.next.prev = sentinel;

        size--;
        return toRemove.item;
    }

    /** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
    public Item removeLast(){
        if (sentinel.prev == sentinel){
            return null;
        }
        ListNode toRemove = sentinel.prev;
        sentinel.prev = toRemove.prev;
        toRemove.prev.next = sentinel;

        size--;
        return toRemove.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * */
    public Item get(int index){
        ListNode pointer = sentinel.next;
        for (int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        return pointer.item;
    }

    public Item getRecursive(int index){
        ListNode node = sentinel.next;
        return getRecursive(index - 1, node.next);
    }

    private Item getRecursive(int index, ListNode node){
        if (index >= 0){ //if select 0, will search -1, but we don't want the sentinel
            getRecursive(index - 1, node.next);
        }
        return node.item;
    }
}
