package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarsGenerator {
    List<Car> carList;
    public CarsGenerator() {
        carList = new ArrayList<>();
    }

    public List<Car> generateCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

}
