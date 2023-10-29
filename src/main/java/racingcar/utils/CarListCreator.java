package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;

public class CarListCreator {

    public static List<Car> createCarsList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static List<Car> createCarsList(String[] carNames, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
        return cars;
    }
}
