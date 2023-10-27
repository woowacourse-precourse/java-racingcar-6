package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarController {

    public Cars makeCar(String name) {
        List<Car> carsList = makeList(name, new ArrayList<>());
        return new Cars(carsList);
    }

    private List<Car> makeList(String names, List<Car> cars) {
        for (String carName : names.split(",")) {
            nameIsNotEmpty(cars, carName.trim());
        }
        return cars;
    }

    private void nameIsNotEmpty(List<Car> cars, String trimmedName) {
        if (!trimmedName.isEmpty()) {
            Car car = new Car(trimmedName);
            cars.add(car);
        }
    }
}
