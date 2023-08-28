public interface Deque<Item> {
    default public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int size();
    public void addFirst(Item x);

    public void addLast(Item x);

    public Item removeFirst();

    public Item removeLast();

    public Item get(int index);

    public void printDeque();



}
