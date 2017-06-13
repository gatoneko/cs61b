/**
 * Created by cyoste on 2017/06/13.
 */
public interface Deque <Item> {
    public void addFirst(Item item);
    public void addLast(Item item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
}
