package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCars(List<String> carNamesWithoutSeparator) {
        List<Car> cars = new ArrayList<>();

        for (String s : carNamesWithoutSeparator) {
            cars.add(new Car(s));
        }
        return cars;
    }
}
