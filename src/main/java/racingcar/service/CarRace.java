package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRace {
    public static List<Car> formatCarNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            Car car = new Car(carname);
            cars.add(car);
        }
        return cars;
    }
}
