package Lesson_5.number;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberModule {

    public int[] numbersGenerator(int count) {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++)
            numbers[i] = ThreadLocalRandom.current().nextInt(count);
        return numbers;
    }
}
