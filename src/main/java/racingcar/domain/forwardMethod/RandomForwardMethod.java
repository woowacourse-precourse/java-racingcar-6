package racingcar.domain.forwardMethod;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomForwardMethod implements ForwardMethod {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MINIMUM_MOVEMENT_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MINIMUM_MOVEMENT_CONDITION;
    }
}
