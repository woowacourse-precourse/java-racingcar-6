package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public Cars createCars(List<String> carsName) {
        List<Car> carsTempHolder = new ArrayList<>();
        Cars cars;

        for (String carName : carsName) {
            Car car = new Car(carName);
            carsTempHolder.add(car);
        }
        cars = new Cars(carsTempHolder);
        return cars;
    }
}
