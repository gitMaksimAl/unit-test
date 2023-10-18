package Homework_3;

public class Primitives {
    
    public static String evenOddNumber(int number) {
        if ((number | 1) > number) return "even";
        return "odd";
    }

    public static boolean numberInInterval(int number) {
        if (number > 25 && number < 100) return true;
        return false;
    }
}
