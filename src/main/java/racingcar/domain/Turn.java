package racingcar.domain;

import static racingcar.constant.CarRacingErrorMessage.TRY_COUNT_NUMBER_FORMAT_ERROR_MESSAGE;

import java.util.regex.Pattern;

public class Turn {
    private final int count;
    private final static String NUMBER_PATTERN = "\\d+";
    private final static Pattern NUMBER_FORMAT = Pattern.compile(NUMBER_PATTERN);

    private Turn(int count) {
        this.count = count;
    }

    public static Turn fromTryCount(String count) {
        validate(count);
        return new Turn(Integer.parseInt(count));
    }


    public int getCount() {
        return count;
    }

    private static void validate(String tryToMoveCount) {
        validateTryCountFormat(tryToMoveCount);
    }

    private static void validateTryCountFormat(String tryToMoveCount) {
        if (!isNumberFormat(tryToMoveCount)) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static boolean isNumberFormat(String text) {
        return NUMBER_FORMAT.matcher(text).matches();
    }
}
