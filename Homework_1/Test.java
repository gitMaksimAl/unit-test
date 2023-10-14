package Homework_1;
import static org.assertj.core.api.Assertions.*;

public class Test {
    
    // check maximal exponent precision
    public static void maxPrecisionTest(double maxPrecision, double value, double testValue) {
        assert value < testValue: String.format("Fail on mantissa(%f).", testValue);
        assert value + maxPrecision > testValue: String.format("Fail on exponent precision(%f).", maxPrecision);
    }

    // zero test
    public static void zeroTest(double testValue) {
        assert 0.0 == testValue: "Fail on zero.";
    }

    // negative test
    public static void negativeTest(double testValue) {
        assert Double.isNaN(testValue): "Fail on negative value.";
    }

    // maximum discount test
    public static void tooMuchDiscountTest(double testValue, double price) {
        double tooMuch = price - (price / 100f * 35f);
        assertThat(tooMuch).isLessThan(testValue);
    }

    // zero purchase test
    public static void zeroPurchaseTest() {
        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 0))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage("Invalid arguments.");
    }

    public static void main(String[] args) {
        // sqrt tests
        maxPrecisionTest(Calculator.err, 7.0f, Calculator.squareRootExtraction(49));
        zeroTest(Calculator.squareRootExtraction(0));
        negativeTest(Calculator.squareRootExtraction(-16));

        // discount tests
        double purchaseAmount = 523f;
        tooMuchDiscountTest(Calculator.calculatingDiscount(purchaseAmount, 3), purchaseAmount);
        purchaseAmount = 1240f;
        tooMuchDiscountTest(Calculator.calculatingDiscount(purchaseAmount, 3), purchaseAmount);
        zeroPurchaseTest();

        System.out.println("All tests done!");
    }
}
