package racingcar;

import java.util.List;

public class User {

    String name;
    int length;

    public User() {

    }

    public User(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void inputCheck(List<User> users) {
        for (User u : users) {
            String carName = u.name;
            if (carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

}
