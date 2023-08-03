public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;

    // R = size / capacity;
    // if (capacity >= 16) R >= 0.25;
    private double R; // usage ratio

    // front == rear时，队列为空
    // (rear + 1) % capacity == front时，队列为满
    private int front; // 头指针
    private int rear; // 尾指针

    // Creates an empty array deque.
    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[8];
        front = 0;
        rear = 0;
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        // for循环是将旧数组中的元素移动到新数组中，这个移动过程该怎么实现呢？
        int j = 0, k = front;
        for( ; k != front; j ++)
        {
            a[j] = items[k];
            k = (k + 1) % capacity;
        }

        front = 0;
        rear = j;
        items = a;
    }

    // Adds an item of type T to the front of the deque.
    // 先判断队列是否满，若满则调整队列大小
    public void addFirst(T item) {
        if( isFull() ) {
            // 如果此时数组已满，令数组的容量扩大二倍，并将旧数组的元素移动到新数组中
            capacity *= 2;
            resize(capacity);
        }

        front = (front - 1 + capacity) % capacity;
        items[front] = item;

        size ++;
    }

    // Adds an item of type T to the back of the deque.
    // 先判断队列是否满，若满则调整队列大小
    public void addLast(T item) {
        if( isFull() ) {
            capacity *= 2;
            resize(capacity);
        }

        items[rear] = item;
        rear = (rear + 1 + capacity) % capacity;

        size ++;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns true if deque is full, false otherwise.
    public boolean isFull() {
        if( (rear + 1) % capacity == front) {
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
        int i = front;
        // 若初始为空，然后 addFirst，那么该如何打印？
        while(i != rear) {
            // note: please note the print method
            System.out.print(items[i] + " ");
            i ++;
        }
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if( isEmpty() ) return null;

        T temp;
        temp = items[front];
        front = (front + 1 + capacity) % capacity;

        return temp;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if( isEmpty() ) return null;

        T temp = items[rear];
        rear = (rear - 1 + capacity) % capacity;

        return temp;
    }

    public int minusOne(int index) {
        return 0;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if(size == 0 || index > size) return null;

        int i = front;
        int j = 0;
        for( ; j <= index; j ++)
        {
            i = (i + 1) % capacity;
        }

        return items[i];
    }
}
