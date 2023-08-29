import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        System.out.println(offByOne.equalChars('a', 'b'));  // true
        assertTrue(offByOne.equalChars('a', 'b'));
        System.out.println(offByOne.equalChars('r', 'q'));  // true

        System.out.println(offByOne.equalChars('a', 'e'));  // false
        assertFalse(offByOne.equalChars('a', 'e'));
        System.out.println(offByOne.equalChars('z', 'a'));  // false
        System.out.println(offByOne.equalChars('a', 'a'));  // false

        System.out.println(offByOne.equalChars('&', '%'));  // true

        System.out.println(offByOne.equalChars('a', 'B'));  // false

        System.out.println(offByOne.equalChars('1', '2'));  //

        System.out.println(offByOne.equalChars('1', '5'));
        System.out.println(offByOne.equalChars('1', '%'));
        System.out.println(offByOne.equalChars('@', '&'));

    }
    
    // Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}

