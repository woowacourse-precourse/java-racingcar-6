package racingcar.domain.car;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {
    private static final String PREFIX = "";
    private static final String DELIMITER_AND_SUFFIX = "\n";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    protected String moveCarAndGetResult(Supplier<Boolean> moveOrNot) {
        cars.forEach(car -> car.move(moveOrNot.get()));
        return this.makeMoveResult();
    }

    protected String getWinner() {
        WinCars winCars = new WinCars();
        cars.forEach(winCars::checkCarWinGame);
        return winCars.getWinCars();
    }

    private String makeMoveResult() {
        return cars.stream()
                .map(Car::makeMoveResultMessage)
                .collect(Collectors.joining(DELIMITER_AND_SUFFIX, PREFIX, DELIMITER_AND_SUFFIX));
    }
}
