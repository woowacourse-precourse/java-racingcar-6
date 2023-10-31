package racingcar.utils;

import java.util.Collections;
import java.util.List;

public class Validator {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MAX_FREQUENCY = 1;
    public static final int MIN_TRY_NUMBER = 1;

    private Validator() {
        throw new AssertionError();
    }

    public static void validate(List<String> names) {
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(MessageConstant.BLANK_MESSAGE);
            } else if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(MessageConstant.MAX_CAR_NAME_LENGTH_MESSAGE);
            } else if (Collections.frequency(names, name) > MAX_FREQUENCY) {
                throw new IllegalArgumentException(MessageConstant.MAX_FREQUENCY_MESSAGE);
            }
        }
    }

    public static void validate(int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(MessageConstant.MIN_TRY_NUMBER_MESSAGE);
        }
    }
}
