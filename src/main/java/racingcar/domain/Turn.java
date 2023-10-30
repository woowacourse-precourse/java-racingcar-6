package racingcar.domain;

import static racingcar.constant.RacingCarErrorMessage.TRY_COUNT_NUMBER_FORMAT_ERROR_MESSAGE;

import java.util.regex.Pattern;

public class Turn {
    private final int count;
    private final static String NUMBER_PATTERN = "\\d+";
    private final static Pattern NUMBER_FORMAT = Pattern.compile(NUMBER_PATTERN);

    public Turn(String count) {
        validateTryCount(count);
        this.count = Integer.parseInt(count);
    }


    public int getCount() {
        return count;
    }

    private void validateTryCount(String tryToMoveCount) {
        validateTryCountFormat(tryToMoveCount);
    }

    private void validateTryCountFormat(String tryToMoveCount) {
        if (!isNumberFormat(tryToMoveCount)) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private boolean isNumberFormat(String text) {
        return NUMBER_FORMAT.matcher(text).matches();
    }
}
