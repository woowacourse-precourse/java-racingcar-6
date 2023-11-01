package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarManager {

    public static void validateNames(List<String> carNames) {
        Validator.checkCount(carNames);
        Validator.checkBlank(carNames);
        Validator.checkLength(carNames);
        Validator.checkDuplication(carNames);
    }

    public static List<String> createNames(String userInput) {
        Validator.checkComma(userInput);
        return Arrays.asList(userInput.split(","));
    }

    public static void trimNames(List<String> carNames) {
        carNames.replaceAll(String::trim);
    }
}
