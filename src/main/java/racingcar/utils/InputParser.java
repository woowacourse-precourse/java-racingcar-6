package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class InputParser {

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public static List<Car> convertNamesToCars(List<String> carNames){
        return carNames.stream()
            .map(carName -> new Car(carName, 0))
            .collect(Collectors.toList());
    }

}
