package racingcar.validator;

import static racingcar.messages.ErrorMessage.CAR_NAMES_NOT_UNIQUE;
import static racingcar.messages.ErrorMessage.CAR_NAME_LENGTH_OUT_OF_RANGE;
import static racingcar.messages.ErrorMessage.TRY_COUNT_NOT_INTEGER;
import static racingcar.messages.ErrorMessage.TRY_COUNT_NOT_POSITIVE;
import static racingcar.messages.ViewMessage.INPUT_SEPARATOR;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static InputValidator instance;
    private static int NAME_MIN_LENGTH = 1;
    private static int NAME_MAX_LENGTH = 5;
    private static int MIN_TRY_COUNT = 1;

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

    public void validateNameLengthRange(String names) {
        String[] nameArray = names.split(INPUT_SEPARATOR);

        for (String name : nameArray) {
            if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_OUT_OF_RANGE);
            }
        }
    }

    public void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_INTEGER);
        }
    }

    public void validatePositiveNumber(int number) {
        if (number < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_POSITIVE);
        }
    }
}