package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}
