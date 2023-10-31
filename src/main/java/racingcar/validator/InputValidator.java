package racingcar.validator;

import static racingcar.messages.ErrorMessage.CAR_NAMES_NOT_UNIQUE;
import static racingcar.messages.ErrorMessage.CAR_NAME_LENGTH_OUT_OF_RANGE;
import static racingcar.messages.ViewMessage.INPUT_SEPARATOR;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static InputValidator instance;
    private static int NAME_MIN_LENGTH = 1;
    private static int NAME_MAX_LENGTH = 5;

    private InputValidator() {}

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    public void validateNameDuplication(String names) {
        String[] nameArray = names.split(INPUT_SEPARATOR);
        Set<String> uniqueNameSet = new HashSet<>();

        for (String name : nameArray) {
            uniqueNameSet.add(name.strip());
        }

        if (nameArray.length != uniqueNameSet.size()) {
            throw new IllegalArgumentException(CAR_NAMES_NOT_UNIQUE);
        }
    }

    public void validateNameLengthRange(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OUT_OF_RANGE);
        }
    }
}
