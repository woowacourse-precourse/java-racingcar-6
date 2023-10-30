package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> fromNameString(String nameString) {
        String[] names = nameString.split(",");
        return Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public static String toNameString(List<Car> cars) {
        if (cars.size() == 1) {
            return cars.get(0).getName();
        }
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
