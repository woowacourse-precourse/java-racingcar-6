package racingcar.domain;

import static racingcar.constant.ErrorMessage.COUNT_NUMBER_ERROR_MESSAGE;

public class Racing {
    private static int count;

    public Racing(String count) {
        validateMoveCount(count);
        this.count = Integer.parseInt(count);
    }

    public static int getCount() {
        return count;
    }

    private void validateMoveCount(String Count) {
        if (!isNumberFormat(Count)) {
            throw new IllegalArgumentException(COUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isNumberFormat(String text) {
        return text.matches("\\d+");
    }
}
