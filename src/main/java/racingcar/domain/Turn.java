package racingcar.domain;

import static racingcar.constant.RacingCarErrorMessage.TRY_COUNT_NUMBER_FORMAT_ERROR_MESSAGE;

public class Turn {
    private final int count;

    public Turn(String count) {
        validateTryToMoveCount(count);
        this.count = Integer.parseInt(count);
    }


    public int getCount() {
        return count;
    }

    private void validateTryToMoveCount(String tryToMoveCount) {
        if (isNotNumberFormat(tryToMoveCount)) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private boolean isNotNumberFormat(String text) {
        return !text.matches("\\d+");
    }
}
