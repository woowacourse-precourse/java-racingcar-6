package racingcar.model.vo;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public record CarList(
        List<Car> cars
) {

    public static CarList of(final List<Car> cars) {
        return new CarList(cars);
    }

    public static CarList registerCars(final String[] carNames) {
        List<Car> carList = Arrays.stream(carNames)
                .map(Car::new)
                .toList();

        return new CarList(carList);
    }

    public int getMaxForwardCount() {
        return this.cars.stream()
                .map(Car::getForwardCount)
                .reduce(Integer::max)
                .orElse(0);
    }

    public boolean isEmpty() {
        return this.cars.isEmpty();
    }

}
