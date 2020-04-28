
public interface Deque<Thing> {
    public void addFirst(Thing item);
    public Thing removeFirst();
    public void addLast(Thing item);
    public Thing removeLast();
    public int size();
    public boolean isEmpty();
    public Thing get(int index);
    public void printDeque();
}