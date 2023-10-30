package racingcar;

import java.util.List;

public class Race {
    public static void startRace(List<Car> cars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}
