package racingcar.validator;

import racingcar.exception.RacingCarException;

import java.util.List;

import static racingcar.exception.ErrorMessage.DUPLICATED;
import static racingcar.exception.ErrorMessage.ENDS_WITH_DELIMITER;

public class InputValidator {
    private static final String DELIMITER = ",";

    private InputValidator() {
    }

    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw RacingCarException.of(ENDS_WITH_DELIMITER);
        }
    }

    public static void validateDuplicated(final List<String> input) {
        if (isDuplicated(input)) {
            throw RacingCarException.of(DUPLICATED);
        }
    }

    private static boolean isDuplicated(final List<String> input) {
        long distinctCount = input.stream()
                .distinct()
                .count();
        return distinctCount < input.size();
    }
}
