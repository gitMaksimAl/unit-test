package Lesson_3;

import java.util.ArrayList;
import java.util.List;

public class LessonThree {

    public static String fizzBuzz(int number) {
        if (number % 15 == 0) return "fizzBuzz";
        if (number % 3 == 0) return "fizz";
        if (number % 5 == 0) return "buzz";
        return String.valueOf(number);
    }

    public static boolean firstLastSix(int[] arr) {
        return (arr[0] == 6 || arr[arr.length - 1] == 6);
    }

    public static void main(String[] args) {
        
    }

    public class User {
        String user;
        int password;
        boolean isAuth;

        public User(String name, String passwd) {
            this.user = name;
            this.password = passwd.hashCode();
        }

        public boolean auth(String login, String passwd) {
            this.isAuth = (this.user.equals(login) && this.password == passwd.hashCode());
            return this.isAuth;
        }
    }

    public class UserRepository {
        public List<User> repo;

        public UserRepository() {
            this.repo = new ArrayList<>();
        }

        public void addUser(User newUser) {
            if (newUser.isAuth) this.repo.add(newUser);
        }
    }
}
