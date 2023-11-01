package racingcar.utils;

import java.util.Collections;
import java.util.List;

public class Validator {
    public static final int MIN_NUMBER_OF_CARS = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MAX_FREQUENCY = 1;
    public static final int MIN_TRY_NUMBER = 1;

    private Validator() {
        throw new AssertionError();
    }

    public static void validate(List<String> names) {
        if (names.size() == MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(MessageConstant.MIN_NUMBER_OF_CARS);
        }
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(MessageConstant.EXISTENCE_BLANK);
            } else if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(MessageConstant.MAX_NAME_LENGTH);
            } else if (Collections.frequency(names, name) > MAX_FREQUENCY) {
                throw new IllegalArgumentException(MessageConstant.EXISTENCE_DUPLICATION);
            }
        }
    }

    public static void validate(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(MessageConstant.MIN_TRY_NUMBER);
        }
    }
}
