package racingcar.util;

import static racingcar.constants.PositionConstant.FORWARD_THRESHOLD;
import static racingcar.constants.PositionConstant.VALUE_HIGH_BOUND;
import static racingcar.constants.PositionConstant.VALUE_LOW_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public enum ForwardDecider {
    INSTANCE;

    public boolean isForwardPossible() {
        return checkValueIsOverFour(makeRandomValue());
    }

    private int makeRandomValue() {
        return Randoms.pickNumberInRange(VALUE_LOW_BOUND.getValue(), VALUE_HIGH_BOUND.getValue());
    }

    private boolean checkValueIsOverFour(int randomValue) {
        return randomValue >= FORWARD_THRESHOLD.getValue();
    }
}