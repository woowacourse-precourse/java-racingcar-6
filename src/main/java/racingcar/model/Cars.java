package racingcar.model;

import racingcar.util.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> generateCar(String carName) {
        for (String nowCar : carName.split(",")) {
            CarNameValidator.validateCarName(nowCar);
            Car car = new Car(0, nowCar);
            cars.add(car);
        }
        return cars;
    }
}
