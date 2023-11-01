package racingcar;

import racingcar.utils.Constants;
import racingcar.utils.ErrorMessage;

class MoveCounts {
    private int counts;

    MoveCounts(int counts) {
        validateCounts(counts);
        this.counts = counts;
    }

    private void validateCounts(int counts) {
        if (counts < Constants.MINIMUM_MOVE_COUNTS) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_MINIMUM_MOVE_COUNTS_ERROR_MESSAGE);
        }
    }

    void decreaseMoveCounts() {
        counts--;
    }

    boolean isOver() {
        return counts <= Constants.MINIMUM_MOVE_COUNTS;
    }
}
