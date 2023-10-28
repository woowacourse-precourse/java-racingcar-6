package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.OutputView;

public final class Racing {
    private final List<Car> cars;
    private final int numberOfAttempts;

    public Racing(List<Car> cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<String> startRace() {
        OutputView.displayResult();
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            makeCarMovements();
            OutputView.displayCarMovements(cars);
        }
        return announceWinners();
    }

    private void makeCarMovements() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increasePosition();
            }
        }
    }

    private List<String> announceWinners() {
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
