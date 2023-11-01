package racingcar;

import java.util.List;

public class Validation {

    public static void checkException(List<String> carNameList) {
        if (!checkCarNameLength(carNameList)) {
            throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
        }
        if (!checkDuplicateName(carNameList)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
