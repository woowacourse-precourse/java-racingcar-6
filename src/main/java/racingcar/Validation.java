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

    public static boolean checkCarNameLength(List<String> carNameList) {
        return carNameList.stream()
                .filter(carName -> carName.length() >= NAME_MIN_SIZE && carName.length() <= NAME_MAX_SIZE)
                .count() == carNameList.size();
    }
    public static boolean checkDuplicateName(List<String> carNameList) {
        return carNameList.stream()
                .distinct()
                .count() == carNameList.size();
    }
}
