package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarManager {

    public static void validateNames(List<String> carNames) {
        Validator.checkCarCount(carNames);
        Validator.checkBlank(carNames);
        Validator.checkLength(carNames);
        Validator.checkDuplication(carNames);
    }

    public static List<String> createNames(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static void trimNames(List<String> carNames) {
        carNames.replaceAll(String::trim);
    }
}
