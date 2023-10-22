package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Homework_3.Primitives;

import static org.assertj.core.api.Assertions.*;

public class PrimitivesTest {
    
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024})
    public void isEven(int n) {
        assertThat(Primitives.evenOddNumber(n)).isEqualTo("even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9, 7, 33, 11, 71, 13, 999, 1001})
    public void isOdd(int n) {
        assertThat(Primitives.evenOddNumber(n)).isEqualTo("odd");
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 9, 15, 25, 101, 150, 255})
    public void notInRange(int n) {
        assertFalse(Primitives.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 33, 44, 55, 66, 77, 88, 99})
    public void inRange(int n) {
        assertTrue(Primitives.numberInInterval(n));
    }
}
