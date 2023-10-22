package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import Lesson_3.LessonThree;
import Lesson_3.LessonThree.User;
import Lesson_3.LessonThree.UserRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class RepositoryTestHW {
    UserRepository repo;

    @BeforeAll
    public void repoHaveFourUsers() {
        LessonThree instance = new LessonThree();
        this.repo = instance.new UserRepository();
        User user1 = instance.new User("Anton", "123456");
        user1.auth("Anton", "123456");
        repo.addUser(user1);
        User user2 = instance.new User("Vadim", "654321");
        user2.auth("Vadim", "654321");
        repo.addUser(user2);
        User user3 = instance.new User("Admin", "01012023", true);
        user3.auth("Admin", "01012023");
        repo.addUser(user3);
        User user4 = instance.new User("Verblud", "010101");
        user4.auth("Verblud", "010101");
        repo.addUser(user4);
        assertThat(this.repo.repo).containsExactlyInAnyOrder(user1, user2, user3, user4);
    }

    @Test
    public void standWithAdmin() {
        this.repo.logoutUsers();
        assertThat(this.repo.repo).anyMatch(user -> user.isAdmin() && user.isLogin());
    }

    @Test
    public void usersOut() {
        this.repo.logoutUsers();
        assertThat(this.repo.repo).filteredOn(user -> !user.isAdmin()).allMatch(user -> !user.isLogin());
    }
}