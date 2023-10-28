package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.OutputView;

public class Racing {
    public static List<String> startRace(List<Car> cars, int numberOfAttempts) {
        OutputView.displayResult();
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            makeCarMovements(cars);
            OutputView.displayCarMovements(cars);
        }
        return announceWinners(cars);
    }

    private static void makeCarMovements(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increasePosition();
            }
        }
    }

    private static List<String> announceWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
