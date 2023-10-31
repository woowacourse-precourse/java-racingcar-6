package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class Converter {

    public static List<String> convertStringToList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());
    }

    public static List<Car> convertStringListToCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static Long convertStringToLong(String gameCount) {
        return Long.parseLong(gameCount);
    }
}
