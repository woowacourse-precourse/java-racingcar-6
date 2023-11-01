package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final int RANGE_MIN = 0;
    private final int RANGE_MAX = 9;
    private final int STANDARD_NUMBER = 4;

    public boolean getMovement() {
        return getRandomNumber() >= STANDARD_NUMBER;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
    }

}
