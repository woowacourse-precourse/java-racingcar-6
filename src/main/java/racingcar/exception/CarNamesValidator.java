package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNamesValidator {

    public static final String EMPTY_CAR_NAME_MESSAGE = "자동차 이름은 필수 항목입니다. 빈 값은 허용되지 않습니다.";
    public static final String DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차 이름이 존재합니다.";

    private CarNamesValidator() {
    }

    public static void validateCarNames(List<String> carNames) {
        if (hasEmptyName(carNames)) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_MESSAGE);
        }
        if (hasDuplicate(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
        }
    }

    private static boolean hasEmptyName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicate(List<String> carNames) {
        Set<String> names = new HashSet<>();
        for (String carName : carNames) {
            if (names.contains(carName)) {
                return true;
            }
            names.add(carName);
        }
        return false;
    }
}
