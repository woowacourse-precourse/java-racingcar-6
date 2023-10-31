package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import racingcar.constant.ExceptionMessage;

public class CarNameSeperator {

    private static final String DILIMITER = ",";
    private static final String DOUBLE_DELIMITER = ",,";

    public List<String> separateCarNames(final String input) {
        validateNoName(input);
        return Arrays.stream(input.split(DILIMITER)).toList();
    }

    private void validateNoName(final String input) {
        if (input.startsWith(DILIMITER) || input.endsWith(DILIMITER) || input.contains(DOUBLE_DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_IS_BLANK.getMessage());
        }
    }
}
