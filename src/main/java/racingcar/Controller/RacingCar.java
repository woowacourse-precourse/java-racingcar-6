package racingcar.Controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.View.InputView;

public class RacingCar {
    public static void run() {

        List<String> carNames = InputView.readCarNames();
        List<Car> cars = initializeCars(carNames);

        int numberOfAttempts = InputView.readNumberAttempts();

        race(cars, numberOfAttempts);

    }

    public static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return cars;
    }

    public static void race(List<Car> cars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
    public static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.carPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public static List<String> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winners = cars.stream()
                .filter(car -> car.carPosition == maxPosition)
                .map(car -> car.carName)
                .collect(Collectors.toList());
        return winners;
    }
}
