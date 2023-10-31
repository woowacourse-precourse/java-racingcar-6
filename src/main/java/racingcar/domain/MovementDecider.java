package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementDecider {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;

    public boolean movable() {
        return generateRandomNumber() >= MOVE_CONDITION;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
