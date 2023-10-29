package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.Car;

public final class CarListMaker {
    private static final String COMMA = ",";

    public static List<Car> makeCarList(String names) {
        return Arrays.stream(names.split(COMMA))
                .map(Car::new)
                .toList();
    }
}
