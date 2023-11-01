package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.message.ExceptionMessage;

public class CarNameSeperator {

    private static final String DELIMITER = ",";
    private static final String DOUBLE_DELIMITER = ",,";

    public List<String> seperateCarNames(final String input) {
        validateNoName(input);
        return Arrays.stream(input.split(DELIMITER)).toList();
    }

    private void validateNoName(final String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER) || input.contains(DOUBLE_DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_IS_BLANK.getMessage());
        }
    }
}
