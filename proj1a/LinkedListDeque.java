public class LinkedListDeque<T> {
    public class TNode {
        public TNode prev;
        public T item;
        public TNode next;
        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;
    public T item0;

    // Creates an empty linked list deque.
    // note: the first time I write: sentinel = new TNode(sentinel, item0, sentinel);
    //       but it was wrong;
    public LinkedListDeque() {
        sentinel = new TNode(null, item0, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        size ++;
        TNode p = new TNode(sentinel, item, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        size ++;
        TNode p = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        // note: the analyzing condition is not: sentinel.next == null
        //       because we use the Circular Sentinel;
        if(sentinel.next == sentinel) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        TNode p = sentinel;
        while(p.next != sentinel) {
            // note: please note the print method
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if(sentinel.next == null) {
            return null;
        }
        size --;

        T i = sentinel.next.item;
        TNode p = sentinel.next.next;
        p.prev = sentinel;  // size可能是1,那么sentinel.next.next,这样写也对
        sentinel.next = sentinel.next.next;

        return i;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if(sentinel.next == null) {
            return null;
        }
        size --;

        T i = sentinel.prev.item;
        TNode p = sentinel.prev.prev;
        p.next = sentinel;
        sentinel.prev = p;

        return i;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if(size == 0 || index > size) return null;

        TNode p = sentinel;
        for(int k = 0; k <= index; k ++) {
            p = p.next;
        }

        return p.item;
    }

    // Same as get, but uses recursion.
    // note:  practice more;
    public T getRecursive(int index) {
        int i = 0;
        TNode p = sentinel;


        return sentinel.item;
    }
}
