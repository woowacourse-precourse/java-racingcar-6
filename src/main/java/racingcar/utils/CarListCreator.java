package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarListCreator {

    public static List<Car> createCarsList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
