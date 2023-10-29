package racingcar.player;

import racingcar.exception.ExceptionMessage;

public class Player {
    int count;

    public void moveOnInput(String count) {
        if (validateCount(count)) {
            this.count = Integer.parseInt(count);
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
        return count;
    }
}
