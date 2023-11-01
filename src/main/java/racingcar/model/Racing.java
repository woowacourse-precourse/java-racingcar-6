package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.view.OutputView;

public final class Racing {
    private static final int INITIAL_ATTEMPT = 0;
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int MINIMUM_MOVEMENT_THRESHOLD = 4;
    private static final int OPTIONAL_POSITION = 0;
    private final List<Car> cars;
    private final int numberOfAttempts;

    public Racing(List<Car> cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<String> startRace() {
        OutputView.displayResult();
        IntStream.range(INITIAL_ATTEMPT, numberOfAttempts).forEach(attempt -> {
            makeCarMovements();
            OutputView.displayCarMovements(cars);
        });
        return announceWinners();
    }

    private void makeCarMovements() {
        cars.stream().filter(car -> Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
                        >= MINIMUM_MOVEMENT_THRESHOLD)
                .forEach(Car::increasePosition);
    }

    private List<String> announceWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(OPTIONAL_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
