package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarManager {

    public void validateCarNames(List<String> carNames) {
        Validator.checkCarCount(carNames);
        Validator.checkBlank(carNames);
        Validator.checkLength(carNames);
        Validator.checkDuplication(carNames);
    }
    public static List<String> createCarNames(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static void trimCarNames(List<String> carNames) {
        carNames.replaceAll(String::trim);
    }
}
