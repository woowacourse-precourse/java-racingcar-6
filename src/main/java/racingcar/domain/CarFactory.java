package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public static List<Car> fromNameString(String nameString) {
        String[] names = nameString.split(",");
        return Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public static String toNameString(List<Car> cars) {
        // TODO: 구현 필요
        return null;
    }
}
