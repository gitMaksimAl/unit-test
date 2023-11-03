package test;

import org.checkerframework.checker.units.qual.radians;
import org.junit.jupiter.api.Test;

import Lesson_5.user.UserRepository;
import Lesson_5.user.UserService;
import Lesson_5.number.MaxNumberModule;
import Lesson_5.number.RandomNumberModule;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;


class MainTest {

    /**
     * 4.0. Проверка работы Mockito
     */
     @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("one");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова  “Hello World”,
     * и проверить это поведение с помощью утверждений
     */
      @Test
      public void iteratorWillReturnHelloWorld() {
          // Arrange
          Iterator iteratorMock = mock(Iterator.class);
          when(iteratorMock.next()).thenReturn("Hello").thenReturn("World");
          String resuString = iteratorMock.next() + " " + iteratorMock.next();
          assertThat(resuString).isEqualTo("Hello World");
      }

      @Test
      public void generatorTest() {
        RandomNumberModule generator = new RandomNumberModule();
        int[] numbers = generator.numbersGenerator(10);
        assertEquals(10, numbers.length, "how so");
      }

      @Test
      public void maxNumberTest() {
        MaxNumberModule module = new MaxNumberModule();
        int[] numbers = {3, 4, 1, 9, 0, 5};
        assertEquals(9, module.findMaxNumber(numbers));
      }

      @Test
      public void numbersIntegrationTest() {
        RandomNumberModule generator = new RandomNumberModule();
        MaxNumberModule module = new MaxNumberModule();
        int[] numbers = {3, 2, 7, 1, 0, -7};
        int max = module.findMaxNumber(numbers);
        Arrays.sort(numbers);
        assertEquals(max, numbers[numbers.length - 1], "how so");
      }

      @Test
      public void userIntegrationTest() {
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        assertEquals("User 1", service.getUserName(1));
      }
}