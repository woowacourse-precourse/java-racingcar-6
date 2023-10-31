package racingcar.utils.validation;

import java.util.List;
import racingcar.utils.constant.Constant;

public class InputValidation {
    public static void validateNameLength(String carName) {
        if (carName.length() > Constant.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNameDuplicated(List<String> carNames) {
        long distinctLength = carNames.stream().distinct().count();
        if (carNames.size() != distinctLength) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCountRange(int count) {
        if (count < Constant.MIN_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRandomNumberRange(int num) {
        if (num < Constant.MIN_RANDOM_NUMBER || num > Constant.MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
