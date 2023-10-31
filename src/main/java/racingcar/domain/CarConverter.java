package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarConverter {
    public static List<Car> convertToCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
