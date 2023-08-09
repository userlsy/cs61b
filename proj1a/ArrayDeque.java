/**  用数组实现双端队列
    使用系数 R = size / capacity;
    if (capacity >= 16) R >= 0.25;
    front == rear时，队列为空
    (rear + 1) % capacity == front时，队列为满. */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;
    /** usage ratio */
    private double R;

    /** front 是队列中第一个元素的下标位置 */
    private int front;
    /** rear 是队列中最后一个元素的后一个位置 */
    private int rear;

    // Creates an empty array deque.
    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[8];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    // Returns true if deque is full, false otherwise.
    private boolean isFull() {
        // (rear + 1) % capacity == front 时，数组满
        if ((rear + 1) % capacity != front) {
            return false;
        }
        return true;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        int cap = capacity / 2;
        // for循环是将旧数组中的元素移动到新数组中，这个移动过程该怎么实现呢？
        int j = 0, k = front;
        // 注意 for 循环退出条件：是 k != rear; 不是 k < rear; 注意这是数组构建的双端队列
        for ( ; k != rear; j++) {
            a[j] = items[k];

            // 因为要把原属组中的元素复制到新数组，cap 应该是原属组的容量大小
            k = (k + 1 + cap) % cap;
        }

        front = 0;
        rear = j;
        items = a;
    }

    // Adds an item of type T to the front of the deque.
    // 先判断队列是否满，若满则调整队列大小
    public void addFirst(T item) {
        if (isFull()) {
            // 如果此时数组已满，令数组的容量扩大二倍，并将旧数组的元素移动到新数组中
            capacity *= 2;
            resize(capacity);
        }

        // front 是数组中的第一个元素的下标，front 要先往前移动一个位置，再插入
        front = (front - 1 + capacity) % capacity;
        items[front] = item;

        size++;
    }

    // Adds an item of type T to the back of the deque.
    // 先判断队列是否满，若满则调整队列大小
    public void addLast(T item) {
        if (isFull()) {
            capacity *= 2;
            resize(capacity);
        }

        // rear 是数组中的最后一个元素的后一个位置，所以要先插入，再把 rear 往后移动一个位置
        items[rear] = item;
        rear = (rear + 1 + capacity) % capacity;

        size++;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

//        if (capacity >= 16 && R < 0.25) {
//            capacity /= 2;
//            resize(capacity);
//        }

        // 因为 front 指向数组第一个元素的下标，所以先将第一个元素赋值给 中间变量，再将 front 的位置后移一位
        T temp = items[front];
        front = (front + 1 + capacity) % capacity;
        size--;

        return temp;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

//        if (capacity >= 16 && R < 0.25) {
//            capacity /= 2;
//            resize(capacity);
//        }

        // 因为 rear 指向数组最后一个元素的后一个位置，所以先将 rear 向前移动一位，再将 值 赋给中间变量
        rear = (rear - 1 + capacity) % capacity;
        T temp = items[rear];
        size--;

        return temp;
    }

    private int minusOne(int index) {
        return 0;
    }

    // Gets the item at the given index,
    // where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (size == 0 || index > size || index < 0) {
            return null;
        }

        int i = front;
        int j = 0;
        for ( ; j < index; j++) {
            // 这里也不是简单的 i ++
            i = (i + 1) % capacity;
        }

        return items[i];
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        int i = front;
        /* 若初始为空，然后 addFirst，那么该如何打印？. */
        while (i != rear) {
            // note: please note the print method.
            System.out.print(items[i] + " ");

            /* 此处不是简单的 i ++，因为这是数组表示的双端队列. */
            i = (i + 1 + capacity) % capacity;
        }
    }

}