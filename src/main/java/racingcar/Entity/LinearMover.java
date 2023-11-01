package racingcar.Entity;

import racingcar.Config;
import racingcar.Util;

public class LinearMover implements Mover {
    private int location;

    public LinearMover(int location) {
        this.location = location;
    }

    @Override
    public void moveForward() {
        if (isMovable()) {
            this.plusLocation(Config.FORWARD_STEP);
        }
    }

    private boolean isMovable() {
        int number = Util.getRandomSingleDigit();
        return Util.getBooleanByNumber(number);
    }

    private void plusLocation(int number) {
        this.location += number;
    }

    @Override
    public int getLocation() {
        return this.location;
    }
}