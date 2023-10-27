package racingcar;

import java.util.List;

public class CarListGenerator {
    public static List<Car> getCarList(List<String> carStrings) {
        return carStrings.stream()
                .map(Car::new)
                .toList();
    }
}
