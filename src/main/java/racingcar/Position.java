package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Position {
    private int position;
    private static final int FORWARD_THRESHOLD = 4;
    public static final int VALUE_LOW_BOUND = 0;
    public static final int VALUE_HIGH_BOUND = 9;

    public Position() {
        position = 0;
    }

    public Position(int status) {
        position = status;
    }

    public void attemptForward() {
        if (checkValueIsOverFour(makeRandomValue())) {
            moveForward();
        }
    }

    private int makeRandomValue() {
        return Randoms.pickNumberInRange(VALUE_LOW_BOUND, VALUE_HIGH_BOUND);
    }

    private boolean checkValueIsOverFour(int value) {
        return value >= FORWARD_THRESHOLD;
    }

    private void moveForward() {
        position += 1;
    }

    public ForwardState getForwardState() {
        return new ForwardState(position);
    }

    public int getPosition() {
        return position;
    }
}
