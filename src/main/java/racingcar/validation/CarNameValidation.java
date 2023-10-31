package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class CarNameValidation {
    public static final String ERROR_GAP = "[ERROR] 공백 없이 입력해주세요.";

    public static final String ERROR_LEAST_TWO_CAR_NAME = "[ERROR] 최소 두 개 이상의 자동차 이름을 입력해주세요.";

    public static final String ERROR_SYMBOL_COMMA_DIVISION = "[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분해주세요.";

    public static final String ERROR_ONE_MORE_FIVE_LESS = "[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요.";

    public void validateCarNameAll(String userInput) {
        validateGap(userInput);
        validateLeastName(userInput);
        validateCommaDivision(userInput);
        validateNameLengthLimit(userInput);
    }

    public void validateGap(String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(ERROR_GAP);
        }
    }

    public void validateLeastName(String userInput) {
        if (userInput.split(",").length < 2) {
            throw new IllegalArgumentException(ERROR_LEAST_TWO_CAR_NAME);
        }
    }

    public void validateCommaDivision(String userInput) {
        if (!userInput.contains(",")) {
            throw new IllegalArgumentException(ERROR_SYMBOL_COMMA_DIVISION);
        }
    }

    public void validateNameLengthLimit(String userInput) {
        List<String> carsName = Arrays.asList(userInput.split(","));
        for (String carName : carsName) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(ERROR_ONE_MORE_FIVE_LESS);
            }
        }
    }
}
