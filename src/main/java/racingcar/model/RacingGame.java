package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final NumberGenerator numberGenerator;
    private final int maxTryCount;

    private final Cars cars;
    private int tryCount;

    public RacingGame(int maxTryCount, NumberGenerator numberGenerator, List<String> names) {
        this.numberGenerator = numberGenerator;
        this.cars = createCars(names);
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
    }

    private Cars createCars(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
    public void moveCars() {
        if (isFinished()) {
            throw new IllegalStateException();
        }
        cars.move(numberGenerator);
        tryCount++;
    }

    public boolean isFinished() {
        return tryCount >= maxTryCount;
    }

    public List<Car> getWinners() {
        if (isFinished()) {
            return cars.getWinnerCars();
        }
        throw new IllegalStateException("자동차 경주가 끝나지 않았습니다.");
    }

    public Positions getPositions() {
        return cars.getPositions();
    }
}
