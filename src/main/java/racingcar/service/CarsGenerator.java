package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.configurations.Configurations;
import racingcar.model.Accelerator;
import racingcar.model.Car;

public class CarsGenerator {
    List<Car> carList;
    Accelerator accelerator;
    public CarsGenerator(Configurations config) {
        carList = new ArrayList<>();
        accelerator = new Accelerator(config);
    }

    public List<Car> generateCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name,accelerator);
            carList.add(car);
        }
        return carList;
    }

}
