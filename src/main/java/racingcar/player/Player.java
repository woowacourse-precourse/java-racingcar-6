package racingcar.player;

import racingcar.exception.ExceptionMessage;

public class Player {
    int tryCount;

    public void moveOnInput(String tryCount) {
        if (validateCount(tryCount)) {
            this.tryCount = Integer.parseInt(tryCount);
        }
    }

    private boolean isCountRange(String count) {
        return count != null && count.matches("^[1-9]\\d*$");
    }

    private boolean validateCount(String count) {
        if (!isCountRange(count)) {
            throw new IllegalArgumentException(ExceptionMessage.MOVE_OF_RANGE);
        }
        return true;
    }

    public int getCount() {
        return tryCount;
    }
}
