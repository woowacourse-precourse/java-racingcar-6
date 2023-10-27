package validator;

import static constant.ConstantString.MAX_NAME_LENGTH;
import static constant.ExceptinoString.DUPLICATE_NAME_MESSAGE;
import static constant.ExceptinoString.EMPTY_NAME_MESSAGE;
import static constant.ExceptinoString.MAX_LENGTH_EXCEEDED_MESSAGE;

import domain.Car;
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

    private static void isNameLengthExceeded(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH_EXCEEDED_MESSAGE);
        }
    }

    private static void isNameEmpty(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
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
