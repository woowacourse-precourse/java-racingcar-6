package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {
    Validator validator = new Validator();

    public List<String> splitByComma(String inputCarName) {
        List<String> carNames = Arrays.asList(inputCarName.split(","));
        validator.isLengthOverFive(carNames);
        return carNames;
    }
}
