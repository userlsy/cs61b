import org.junit.Test;

public class TestOffByN {
    static CharacterComparator OffByN = new OffByN(5);

    @Test
    public void testequalChars() {
        OffByN OffBy5 = new OffByN(5);
        System.out.println(OffBy5.equalChars('a', 'f'));  // true
        System.out.println(OffBy5.equalChars('f', 'a'));  // true

        System.out.println(OffBy5.equalChars('f', 'h'));  // false

        OffByN OffBy3= new OffByN(3);
        System.out.println(OffBy3.equalChars('a', 'd'));  // true
        System.out.println(OffBy3.equalChars('z', 'w'));  // true

        System.out.println(OffBy3.equalChars('f', 'h'));  // false
    }
}
