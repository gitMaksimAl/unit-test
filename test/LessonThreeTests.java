package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.provider.ValueSource;

import Lesson_3.LessonThree;
import Lesson_3.LessonThree.UserRepository;
import Lesson_3.LessonThree.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class LessonThreeTests {

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 25})
    public void isBuzz(int n) {
        assertThat(Lesson_3.LessonThree.fizzBuzz(n)).isEqualTo("buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 33, 9})
    public void isFizz(int n) {
        assertThat(Lesson_3.LessonThree.fizzBuzz(n)).isEqualTo("fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45})
    public void isFizzBuzz(int n) {
        assertThat(Lesson_3.LessonThree.fizzBuzz(n)).isEqualTo("fizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 22})
    public void isNum(int n) {
        assertThat(Lesson_3.LessonThree.fizzBuzz(n)).isEqualTo(String.valueOf(n));
    }

    @Test
    public void startwithSix() {
        assertTrue(LessonThree.firstLastSix(new int[]{6, 3, 33, 12, 63, 0}));
    }

    @Test
    public void endWithSix() {
        assertTrue(LessonThree.firstLastSix(new int[]{6, 3, 33, 12, 63, 6}));
    }

    @Test
    public void startEndNoSix() {
        assertTrue(LessonThree.firstLastSix(new int[]{6, 3, 33, 12, 63, 6}));
    }

    @Test
    public void isAuth() {
        LessonThree instance = new LessonThree();
        User user = instance.new User("Anton", "123456");
        assertTrue(user.auth("Anton", "123456"));
    }

    @Test
    public void isNoAuth() {
        LessonThree instance = new LessonThree();
        User user = instance.new User("Anton", "123456");
        assertFalse(user.auth("Anton", "02022023"));
    }

    @Test
    public void userAdded() {
        LessonThree instance = new LessonThree();
        UserRepository repo = instance.new UserRepository();
        User user = instance.new User("Anton", "123456");
        user.auth("Anton", "123456");
        assertThat(repo.repo).contains(user);
    }

    @Test
    public void userNotAdded() {
        LessonThree instance = new LessonThree();
        UserRepository repo = instance.new UserRepository();
        User user = instance.new User("Anton", "123456");
        user.auth("Anton", "02022022");
        assertThat(repo.repo).doesNotContain(user);
    }
}
