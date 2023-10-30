package racingcar.model;

import static racingcar.constants.PositionConstant.FORWARD_THRESHOLD;
import static racingcar.constants.PositionConstant.VALUE_HIGH_BOUND;
import static racingcar.constants.PositionConstant.VALUE_LOW_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final int value;

    public RandomNumber() {
        value = makeRandomValue();
    }

    private int makeRandomValue() {
        return Randoms.pickNumberInRange(VALUE_LOW_BOUND.getValue(), VALUE_HIGH_BOUND.getValue());
    }

    public boolean checkValueIsOverFour() {
        return value >= FORWARD_THRESHOLD.getValue();
    }
}
