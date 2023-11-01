package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public List<Car> createCar(String listCars) {
        List<Car> cars = new ArrayList<>();
        String[] carsNameList = listCars.split(",");

        for(String name:carsNameList) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
