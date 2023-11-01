package racingcar.domain;

import racingcar.generator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.message.ErrorMessage.DUPLICATED_CAR_NAME_ERROR;
import static racingcar.message.ErrorMessage.INVALID_CAR_LIST;

public class CarList {

    private static final String WINNER_DELIMITER = ", ";

    private final RandomNumberGenerator<Boolean> flagGenerator;
    private final List<Car> carList;

    public CarList(List<Car> cars) {
        this.flagGenerator = new CarMoveFlagGenerator();
        validateCarGroup(cars);
        this.carList = cars;
    }

    private void validateCarGroup(List<Car> cars) {
        if (isDuplicate(cars)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR.getMessage());
        }
    }

    private boolean isDuplicate(List<Car> cars) {
        long distinctCars = cars.stream()
                .distinct()
                .count();

        return cars.size() != distinctCars;
    }

    public void moveAll() {
        carList.stream()
                .filter(car -> isMove())
                .forEach(Car::move);
    }

    private boolean isMove() {
        // Boolean NULL Safe equals
        return Boolean.TRUE.equals(flagGenerator.generate());
    }

    public String toProgressMessage() {
        return carList.stream()
                .map(Car::toMessage)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String toWinnerMessage() {
        int winnerScore = getWinnerScore();

        return carList.stream()
                .filter(car -> car.getPosition() == winnerScore)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private int getWinnerScore() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CAR_LIST.getMessage()));
    }
}
