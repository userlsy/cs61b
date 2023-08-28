public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deq =  new LinkedListDeque<Character>();

        for (int i = 0; i < word.length(); i += 1) {
            deq.addLast(word.charAt(i));
        }

        return deq;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deq1 =  new LinkedListDeque<Character>();
        deq1 = wordToDeque(word);

//        deq1.printDeque();

        while (deq1.size() > 1) {
            Character c1 = deq1.removeFirst();
            Character c2 = deq1.removeLast();
            if(c1 != c2) {
                return false;
            }
        }

        return true;
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deq2 =  new LinkedListDeque<Character>();
        deq2 = wordToDeque(word);

        while (deq2.size() > 1) {
            Character c1 = deq2.removeFirst();
            Character c2 = deq2.removeLast();
            if( !cc.equalChars(c1, c2) ) {
                return false;
            }
        }
        return true;
    }
}
