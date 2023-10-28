package racingcar.validators;

import java.util.Arrays;
import java.util.HashSet;

public class InputCarNameValidator {
    public static void validateCarName(String carNames) {
        validateLength(carNames);
        validateDuplicate(carNames);
    }

    private static void validateLength(String carNames) {
        String[] carNameList = carNames.split(",");
        boolean result = Arrays.stream(carNameList).anyMatch(carName -> carName.length() > 5);
        if(result) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateDuplicate(String carNames) {
        String[] carNameList = carNames.split(",");
        HashSet<String> set = new HashSet<>();
        boolean result = Arrays.stream(carNameList).anyMatch(carName -> !set.add(carName));
        if(result) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
