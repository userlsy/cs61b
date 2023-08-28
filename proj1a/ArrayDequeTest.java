public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void DequeTest() {
        System.out.println("Running  Deque test.");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        printTestStatus(passed);

        lld1.addLast(0);
        System.out.println(lld1.removeLast());      /* ==> 0 */
        lld1.addFirst(2);
        lld1.addLast(3);
        lld1.addFirst(4);
        System.out.println(lld1.removeFirst());     /* ==> 4 */
        lld1.addLast(6);
        lld1.addLast(7);
        lld1.addLast(8);
        System.out.println(lld1.removeLast());      /* ==> 8 */
        System.out.println(lld1.removeLast());     /* ==> 7 */
        System.out.println(lld1.get(1));      /* ==> 3 */
        lld1.addFirst(12);
        lld1.addLast(13);
        lld1.addFirst(14);
        System.out.println(lld1.get(3));      /* ==> 3 */
        lld1.addLast(16);
        System.out.println(lld1.removeFirst());     /* ==> 14 */
        lld1.addLast(18);
        lld1.addLast(19);
        System.out.println(lld1.get(4));          /* expected 13 but ==> null */

        boolean passed1 = checkEmpty(true, lld1.isEmpty());
        printTestStatus(passed1);

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        System.out.println(lld1.size());
    }

    public static void main(String[] args) {
		System.out.println("Running tests.\n");

        DequeTest();
    }
}
