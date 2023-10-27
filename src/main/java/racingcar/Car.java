package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {
    public static List<String> splitByComma(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(","));
        Validator.isLengthOverFive(carNames);
        return carNames;
    }
}
