package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;

    public Dice() {}

    protected int roll() {
        return Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
    }

}
