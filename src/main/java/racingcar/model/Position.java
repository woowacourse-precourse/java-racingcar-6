package racingcar.model;

import static racingcar.constants.Constants.SLASH;
import static racingcar.constants.PositionConstant.FORWARD_THRESHOLD;
import static racingcar.constants.PositionConstant.VALUE_HIGH_BOUND;
import static racingcar.constants.PositionConstant.VALUE_LOW_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class Position {
    private int position;

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
        return Randoms.pickNumberInRange(VALUE_LOW_BOUND.getValue(),
                VALUE_HIGH_BOUND.getValue());
    }

    private boolean checkValueIsOverFour(int value) {
        return value >= FORWARD_THRESHOLD.getValue();
    }

    private void moveForward() {
        position += 1;
    }

    public String getForwardState() {
        return switchCountToSlash();
    }

    private String switchCountToSlash() {
        return SLASH.repeat(position);
    }

    public int getPosition() {
        return position;
    }
}
