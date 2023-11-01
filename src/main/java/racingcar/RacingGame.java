package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<String> carNames, int attempts) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public void start() {
        OutputView.printHeader();
        for (int i = 0; i < attempts; i++) {
            playRound();
            OutputView.printRound(cars);
        }
        OutputView.printWinners(getWinners());
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
