/**
 * 用链表表示数组.
 * @param <T>
 * @author userlsy
 */
public class LinkedListDeque<T> {
    /** 数组节点的构造. */
    private class TNode {
        /** 指向当前节点的前一个节点. */
        private TNode prev;
        /** 当前节点存储的值. */
        private T item;
        /** 指向当前节点的后一个节点. */
        private TNode next;

        /**
         * 赋值.
         * @param p prev
         * @param i item
         * @param n next
         */
        private TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** 哨兵节点. */
    private TNode sentinel;
    /** 数组中的元素个数，初始为0. */
    private int size;
    /** 定义一个Item类型的变量. */
    private T item0;

    /**
     *  Creates an empty linked list deque.
     *  note: the first time I write:
     *  sentinel = new TNode(sentinel, item0, sentinel);
     *  but it was wrong;
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, item0, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     *  Returns true if deque is empty, false otherwise.
     *  note: the analyzing condition is not: sentinel.next == null
     *        because we use the Circular Sentinel;
     */
    public boolean isEmpty() {
        if (sentinel.next != sentinel) {
            return false;
        }
        return true;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item 参数
     */
    public void addFirst(T item) {
        size++;
        TNode p = new TNode(sentinel, item, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item 参数
     */
    public void addLast(T item) {
        size++;
        TNode p = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * 第 84 行：size可能是1,那么sentinel.next.next,这样写也对
     */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size--;

        T i = sentinel.next.item;
        TNode p = sentinel.next.next;
        p.prev = sentinel;
        sentinel.next = sentinel.next.next;

        return i;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        size--;

        T i = sentinel.prev.item;
        TNode p = sentinel.prev.prev;
        p.next = sentinel;
        sentinel.prev = p;

        return i;
    }

    /**
     * Gets the item at the given index,
     * where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param index 索引
     * @return
     */
    public T get(int index) {
        if (size == 0 || index > size) {
            return null;
        }

        TNode p = sentinel;
        for (int k = 0; k <= index; k++) {
            p = p.next;
        }

        return p.item;
    }

    /**
     * Same as get, but uses recursion.
     * note:  practice more;
     * @param index 索引
     * @return
     */
    public T getRecursive(int index) {
        int i = 0;
        TNode p = sentinel;


        return sentinel.item;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        /** note: please note the print method.
         */
        TNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

}
