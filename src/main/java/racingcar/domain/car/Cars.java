package racingcar.domain.car;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER_AND_SUFFIX = "\n";
    private static final String WRONG_CARS_MESSAGE = "자동차가 비어있습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarsIsNotEmpty(cars);
        this.cars = cars;
    }

    public static Cars makeCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public String moveCarAndGetResult(Supplier<Boolean> moveOrNot) {
        cars.forEach(car -> car.move(moveOrNot.get()));
        return makeMoveResult();
    }

    public String getWinner() {
        WinCars winCars = new WinCars();
        cars.forEach(winCars::checkCarWinGame);
        return winCars.getWinCars();
    }

    private String makeMoveResult() {
        return cars.stream()
                .map(Car::makeMoveResultMessage)
                .collect(Collectors.joining(DELIMITER_AND_SUFFIX))
                + DELIMITER_AND_SUFFIX;
    }

    private void validateCarsIsNotEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(WRONG_CARS_MESSAGE);
        }
    }
}
