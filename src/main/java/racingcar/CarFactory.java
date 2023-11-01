package racingcar;

import java.util.List;

public class CarFactory {

    public static List<Car> createCars(List<String> carNameList) {
        return carNameList.stream().map(e -> new Car(e)).toList();
    }
}
