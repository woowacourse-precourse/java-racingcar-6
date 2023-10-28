package racingcar.utils.validation;

import java.util.List;
import racingcar.utils.constant.Constant;

public class InputValidation {
    public static void validateNameLength(String carName) {
        if (carName.length() > Constant.NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNameDuplicated(List<String> carNames) {
        long distinctLength = carNames.stream().distinct().count();
        if (carNames.size() != distinctLength) {
            throw new IllegalArgumentException();
        }
    }
}
