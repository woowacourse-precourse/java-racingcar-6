package racingcar.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    private static final String COMMA = ",";
    private static final int MAX_STRING = 5;
    private static final int MIN_STRING = 1;


    public static List<String> validationName(String carName) {
        if (carName == null || carName.isBlank() || carName.length() < MIN_STRING || carName.length() > MAX_STRING) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 5 자리로 입력해야 합니다.");
        }
        List<String> carNamesList = Arrays.asList(carName.split(COMMA));
        return carNamesList;
    }

    public static List<String> validationCommaSeparate(List<String> carNames) {
        return null;
    }

    public static List<String> validateAndSplit(String name) {
        return null;
    }

    // 자동차 이름이 같은 경우 예외 처리
    public static void carSameNameValidation(List<String> carNames) {
    }

    // 사용자가 숫자가 아닌 다른 값을 입력했을 경우 예외 처리
    private static void carNumericValidation() {
    }
}

