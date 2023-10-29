package racingcar.domain.car;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {
    private static final String PREFIX = "";
    private static final String DELIMITER_AND_SUFFIX = "\n";
    private static final String WRONG_CARS_MESSAGE = "자동차가 비어있습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        validateCarsIsNotEmpty();
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
                .collect(Collectors.joining(DELIMITER_AND_SUFFIX, PREFIX, DELIMITER_AND_SUFFIX));
    }

    private void validateCarsIsNotEmpty() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(WRONG_CARS_MESSAGE);
        }
    }
}
