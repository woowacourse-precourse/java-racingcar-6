package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarManager {
    private Cars cars;

    public void createCars(String[] names) {
        List<Car> carList = Arrays.stream(names).map(Car::new).toList();

        cars = new Cars(carList);
    }

    public Cars getCars() {
        return cars;
    }
}
