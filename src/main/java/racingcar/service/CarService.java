package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public Cars createCars(List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        return new Cars(carList);
    }
}
