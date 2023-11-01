package domain;

import ui.Output;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        cars = CarFactory.generateCars(carNames);
        isDuplicate(cars);
    }

    private void isDuplicate(List<Car> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException(Output.CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public List<Car> moveCars(RandomNumberStrategy moveStrategy) {
        cars.forEach(car -> car.moveCar(moveStrategy));
        return Collections.unmodifiableList(cars);
    }
}
