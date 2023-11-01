package racingcar;

import java.util.List;

public class GameManager {

    private static final User user = new User();
    private static final Announcer announcer = new Announcer();

    public static List<String> enterCars() {
        announcer.sayEnterCars();
        return user.inputCars();
    }
    public static List<Car> generateCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public static int enterAttempt() {
        announcer.sayEnterAttempt();
        return user.inputAttempt();
    }
}
