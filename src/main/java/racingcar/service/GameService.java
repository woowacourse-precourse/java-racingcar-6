package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class GameService {

    private List<Car> cars;

    public List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
