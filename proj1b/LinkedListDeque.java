public class LinkedListDeque<Item> implements Deque<Item> {
    private class TNode {
        private TNode prev;
        private Item item;
        private TNode next;
        private TNode(TNode p, Item i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;
    private Item item0;

    // Creates an empty linked list deque.
    // note: the first time I write:
    // sentinel = new TNode(sentinel, item0, sentinel);
    //       but it was wrong;
    public LinkedListDeque() {
        sentinel = new TNode(null, item0, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // Returns true if deque is empty, false otherwise.

//    public boolean isEmpty() {
//        // note: the analyzing condition is not: sentinel.next == null
//        //       because we use the Circular Sentinel;
//        if (sentinel.next == sentinel) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    // Returns the number of items in the deque.
    @Override
    public int size() {
        return size;
    }

    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(Item item) {
        size++;
        TNode p = new TNode(sentinel, item, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    // Adds an item of type T to the back of the deque.
    @Override
    public void addLast(Item item) {
        size++;
        TNode p = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    @Override
    public Item removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size--;

        Item i = sentinel.next.item;
        TNode p = sentinel.next.next;
        // size可能是1,那么sentinel.next.next,这样写也对
        p.prev = sentinel;
        sentinel.next = sentinel.next.next;

        return i;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    @Override
    public Item removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size--;

        Item i = sentinel.prev.item;
        TNode p = sentinel.prev.prev;
        p.next = sentinel;
        sentinel.prev = p;

        return i;
    }

    // Gets the item at the given index,
    // where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    @Override
    public Item get(int index) {
        if (size == 0 || index > size) {
            return null;
        }

        TNode p = sentinel;
        for (int k = 0; k <= index; k++) {
            p = p.next;
        }

        return p.item;
    }

    // Same as get, but uses recursion.
    // note:  practice more;
    public Item getRecursive(int index) {
        int i = 0;
        TNode p = sentinel;


        return sentinel.item;
    }

    // Prints the items in the deque from first to last, separated by a space.
    @Override
    public void printDeque() {
        TNode p = sentinel;
        while (p.next != sentinel) {
            // note: please note the print method
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

}
