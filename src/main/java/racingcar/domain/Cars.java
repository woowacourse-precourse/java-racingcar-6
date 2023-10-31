package racingcar.domain;

import static racingcar.utils.ErrorMessages.CAR_COUNT_UNDER_MINIMUM;
import static racingcar.utils.ErrorMessages.NO_SUCH_WINNER;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.NumberGenerator;

public class Cars {
    public static final String DELIMITER = ",";
    public static final int MIN_CAR_COUNT = 2;

    private final List<Car> cars;

    public Cars(String names) {
        validate(names);
        this.cars = convert(names);
    }

    private void validate(String names) {
        String[] carNames = names.split(DELIMITER);
        if (carNames.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_UNDER_MINIMUM);
        }
    }

    private List<Car> convert(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(this::createCar)
                .toList();
    }

    private Car createCar(String name) {
        Name carName = new Name(name);
        return new Car(carName);
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> findWinners() {
        Car winner = findWinner();
        return cars.stream()
                .filter(car -> car.isWinner(winner))
                .toList();
    }

    private Car findWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_WINNER));
    }

    public List<Car> getCars() {
        return cars;
    }
}
