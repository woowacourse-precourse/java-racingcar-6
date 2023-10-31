package racingcar.utils.validator;

import java.util.regex.Pattern;
import racingcar.configuration.ConfigurationConstants;

public class TotalRoundInputValidator {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("^(0|[-]?[1-9]\\d*)$");

    public static void validate(String target) {
        validateNumeric(target);
        validateInteger(target);
        validateRange(target);
    }

    private static void validateNumeric(String target) {
        if (!NUMERIC_REGEX.matcher(target).matches()) {
            throw new IllegalArgumentException(TotalRoundInputExceptionMessage.NOT_NUMERIC.getError());
        }
    }

    private static void validateInteger(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TotalRoundInputExceptionMessage.NOT_INTEGER.getError());
        }
    }

    private static void validateRange(String target) {
        int totalRound = Integer.parseInt(target);
        if (totalRound < ConfigurationConstants.TOTAL_ROUND_MIN_LIMIT
                || totalRound > ConfigurationConstants.TOTAL_ROUND_MAX_LIMIT) {
            throw new IllegalArgumentException(TotalRoundInputExceptionMessage.OUT_OF_RANGE.getError());
        }
    }

    enum TotalRoundInputExceptionMessage {
        NOT_NUMERIC("숫자만 입력해야 합니다."),
        NOT_INTEGER("정수 범위 숫자만 입력해야 합니다."),
        OUT_OF_RANGE(String.format("%d ~ %d 사이의 수만 입력 가능합니다.", ConfigurationConstants.TOTAL_ROUND_MIN_LIMIT,
                ConfigurationConstants.TOTAL_ROUND_MAX_LIMIT));

        private final String error;

        TotalRoundInputExceptionMessage(String error) {
            this.error = error;
        }

        String getError() {
            return error;
        }
    }
}
