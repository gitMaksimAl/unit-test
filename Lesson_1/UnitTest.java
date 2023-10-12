package Lesson_1;
import java.util.Calendar;


/**
 * UnitTest
 */
public class UnitTest {

    public static int sum(int a, int b) {
        assert Integer.MAX_VALUE - Math.abs(a) >= Math.abs(b): "Out of integer range.";
        return a + b;
    }

    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        assert 2023 == calendar.get(1): "Not yet.";
        assert 1 <= calendar.get(2): "Not yet.";
        assert 1 <= calendar.get(1): "Not yet.";
        // assert curentdate.equals("01/01/2023")
        System.out.println("Happy New Year");
    }

    public static void main(String[] args) {
        // System.out.println(sum(1, 4));
        // System.out.println(sum(2, Integer.MAX_VALUE));

        happyNY();
    }
}