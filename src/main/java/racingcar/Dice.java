package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    public static int MINIMUM = 1;
    public static int MAXIMUM = 9;

    public Dice() {}

    protected int roll() {
        return Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
    }

}
