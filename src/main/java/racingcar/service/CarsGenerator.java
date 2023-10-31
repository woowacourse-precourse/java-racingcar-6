package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarsGenerator {
    List<Car> carList;
    Accelerator accelerator;
    public CarsGenerator() {
        carList = new ArrayList<>();
        accelerator = new Accelerator();
    }

    public List<Car> generateCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name,accelerator);
            carList.add(car);
        }
        return carList;
    }

}
