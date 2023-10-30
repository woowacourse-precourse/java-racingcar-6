package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveCondition {

    private final int MOVE_MIN_CONDITION = 4;

    public int randomDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean moveCondition() {
        return MOVE_MIN_CONDITION <= randomDigit();
    }
}
