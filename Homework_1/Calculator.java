package Homework_1;


public class Calculator {
    // measurement error
    static double err = 0.000001;

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  Отрицательные числа
        if (num < 0) return Double.NaN;
        //  Дробные значения корней
        //  Целые
        if (num > 0) {
            double x0 = num;
            double x1 = 1/ 2.0 * (x0 + num / x0);
            double diff = Math.abs(x1 - x0);
            while (diff >= 2 * Calculator.err && diff * diff >= 2 * Calculator.err) {
                x0 = x1;
                x1 = 1/ 2.0 * (x0 + num / x0);
                diff = Math.abs(x1 - x0);
            }
            return x1;
        }
        //  0
        return 0f;
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) throws ArithmeticException{
        if (purchaseAmount <= 0 || discountAmount > (Math.pow(purchaseAmount, 0.3)))
            throw new ArithmeticException("Invalid arguments.");
        double finishPrice = purchaseAmount;
        // some magic-price
        if (purchaseAmount < 500f) finishPrice -= discountAmount;
        else if (purchaseAmount < 1000f) finishPrice -= ++discountAmount;
        else finishPrice = finishPrice - (purchaseAmount * 0.30f - discountAmount);
        return finishPrice;
        // Метод должен возвращать сумму покупки со скидкой
    }
 
}
