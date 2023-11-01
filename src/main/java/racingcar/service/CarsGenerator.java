package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarsGenerator {
    List<Car> carList;

    private static class SingletonCarsGenerator {
        private static final CarsGenerator CARS_GENERATOR = new CarsGenerator();
    }

    public static CarsGenerator getInstance() {
        return SingletonCarsGenerator.CARS_GENERATOR;
    }

    private CarsGenerator() {
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
