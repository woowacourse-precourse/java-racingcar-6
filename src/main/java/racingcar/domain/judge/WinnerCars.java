package racingcar.domain.judge;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.Car;

public class WinnerCars {

    private final List<Car> cars;

    public WinnerCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public boolean hasUniqueWinner() {
        if (Objects.isNull(this.cars)) {
            return false;
        }
        return this.cars.size() == 1;
    }

    public String getUniqueWinnerName() {
        return getUniqueWinner().getName();
    }

    public List<String> getWinnerNames() {
        return this.cars.stream()
                .map(Car::getName)
                .toList();
    }

    private Car getUniqueWinner() {
        if (!hasUniqueWinner()) {
            throw new IllegalStateException("There is no unique winner.");
        }
        return this.cars.get(0);
    }

}
