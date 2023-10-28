package racingcar.validator;

import racingcar.exception.RacingCarException;

import java.util.List;

import static racingcar.exception.ErrorMessage.*;

public class InputValidator {
    private static final Integer ROUND_COUNT_LOWER_BOUND = 1;
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

    public static void validateRoundCount(final Integer roundCount) {
        if (isInvalidRoundCount(roundCount)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }


    private static boolean isInvalidRoundCount(final Integer roundCount) {
        return roundCount < ROUND_COUNT_LOWER_BOUND;
    }

    private static boolean isDuplicated(final List<String> input) {
        long distinctCount = input.stream()
                .distinct()
                .count();
        return distinctCount < input.size();
    }
}
