package test.card;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Lesson_4.card.CreditCard;
import Lesson_4.card.PaymentForm;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

    @Test
    public void paymentTest() {
        CreditCard card = mock(CreditCard.class);
        when(card.getCardNumber()).thenReturn("12345678");
        when(card.getCardHolder()).thenReturn("Nikita Petrov");
        when(card.getExpiryDate()).thenReturn("01/2025");
        when(card.getCvv()).thenReturn("336");

        PaymentForm form = new PaymentForm(card);
        form.pay(100);
        verify(card, times(1)).charge(100);;
    }

}