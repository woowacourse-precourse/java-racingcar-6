package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";


    public static void validateCarNames(String[] splitNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : splitNames) {
            checkNameLength(name);
            checkNameDuplicate(name, uniqueNames);
            uniqueNames.add(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void checkNameDuplicate(String name, Set<String> uniqueNames) {
        if (uniqueNames.contains(name)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
