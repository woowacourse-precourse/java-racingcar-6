package racingcar.common;

import static racingcar.common.Constants.MAX_LENGTH_OF_NAME;
import static racingcar.common.ExceptionMessages.DUPLICATE_CAR_EXCEPTION;
import static racingcar.common.ExceptionMessages.INVALID_FORMAT_INPUT_EXCEPTION;
import static racingcar.common.ExceptionMessages.INVALID_NAME_LENGTH_EXCEPTION;
import static racingcar.common.ExceptionMessages.NOT_NUMERIC_INPUT_EXCEPTION;
import static racingcar.common.ExceptionMessages.NO_COMMA_EXCEPTION;
import static racingcar.common.ExceptionMessages.SMALLER_THAN_ZERO_EXCEPTION;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void hasDuplicates(ArrayList<String> name) {
        Set<String> nameSet = new HashSet<>(name);
        if(nameSet.size() != name.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_EXCEPTION);
        }
    }

    public static void hasDelimiter(String name) {
        if(!name.contains(",")) {
            throw new IllegalArgumentException(NO_COMMA_EXCEPTION);
        }
    }

    public static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION);
        }
    }

    public static void isNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT_EXCEPTION);
        }
    }

    public static void isGreaterThanZero(String input) {
        int chance = Integer.parseInt(input);
        if(chance <= 0) {
            throw new IllegalArgumentException(SMALLER_THAN_ZERO_EXCEPTION);
        }
    }

    public static void validateNamesInput(String names) {
        if(names.startsWith(",") || names.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_FORMAT_INPUT_EXCEPTION);
        }
    }

}
