package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import racingcar.validator.RaceRuleValidator;

public record Cars(List<Car> cars) {

    private static final int START_POSITION = 0;

    public static Cars from(final List<String> carNames) {
        RaceRuleValidator.validate(carNames);
        return new Cars(carNames.stream()
                .map(name -> Car.of(name, START_POSITION))
                .toList());
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveAllForward(final Supplier<Integer> randomNumberSupplier) {
        for (Car car : cars) {
            car.moveForward(randomNumberSupplier.get());
        }
    }

    public List<String> findAllWinnerNames() {
        int winnerPosition = findWinnerPosition();
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private int findWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("우승자를 찾을 수 없습니다."));
    }
}
