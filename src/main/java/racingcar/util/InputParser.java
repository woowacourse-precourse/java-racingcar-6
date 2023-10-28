package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
public class InputParser {
    public static int tryCountParser(String input) {
        return Integer.parseInt(input);
    }

    public static List<Car> carsSplit(String input) {
        return Arrays.stream(input.split(","))
                .map(CarName::new)
                .map(Car::new)
                .toList();
    }
}
