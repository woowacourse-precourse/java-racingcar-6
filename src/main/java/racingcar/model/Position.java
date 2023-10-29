package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.PositionConstant;
import racingcar.dto.ForwardState;

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
        return Randoms.pickNumberInRange(PositionConstant.VALUE_LOW_BOUND.getValue(),
                PositionConstant.VALUE_HIGH_BOUND.getValue());
    }

    private boolean checkValueIsOverFour(int value) {
        return value >= PositionConstant.FORWARD_THRESHOLD.getValue();
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
