package racingcar.validator;

import java.util.ArrayList;
import java.util.List;

public class NameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static boolean isOutOfRange(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicated(List<String> carNames) {
        List<String> nameList = new ArrayList<>();

        for (String name : carNames) {
            if (nameList.contains(name)) {
                return true;
            }
            nameList.add(name);
        }
        return false;
    }

    public static boolean isEmpty(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
