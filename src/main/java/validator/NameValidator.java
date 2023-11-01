package validator;

import static constant.ConstantNumber.MAX_NAME_LENGTH;
import static constant.ConstantNumber.MIN_RACE_CAR_COUNT;
import static constant.ExceptionString.DUPLICATE_NAME_MESSAGE;
import static constant.ExceptionString.EMPTY_NAME_MESSAGE;
import static constant.ExceptionString.MAX_LENGTH_EXCEEDED_MESSAGE;
import static constant.ExceptionString.MIN_CAR_COUNT_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator {
    private NameValidator() {
    }

    public static void validateCarName(String name) {
        isNameEmpty(name);
        isNameLengthExceeded(name);
    }

    private static void isNameEmpty(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
    }

    private static void isNameLengthExceeded(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(MAX_LENGTH_EXCEEDED_MESSAGE);
        }
    }

    public static void isCarCountLessThanTwo(List<String> carNameList) throws IllegalArgumentException {
        if (carNameList.size() < MIN_RACE_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(MIN_CAR_COUNT_MESSAGE);
        }
    }

    public static void isNameDuplicate(List<String> cars) throws IllegalArgumentException {
        Set<String> nameSet = new HashSet<>();
        boolean hasDuplicate = cars.stream()
                .anyMatch(carName -> !nameSet.add(carName));

        if (hasDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }
    }
}
