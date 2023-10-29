package racingcar.domain.caractions;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCarsFromNames(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNameList) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
