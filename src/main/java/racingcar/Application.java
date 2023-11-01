package racingcar;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        int attempt = user.numAttempt();
        System.out.println(attempt);
        Car car = new Car();
        String name = Arrays.toString(car.carname());
        System.out.println(name);

    }
}
