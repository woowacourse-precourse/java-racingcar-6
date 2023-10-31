package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    private static final int ZERO = 0;
    private static final int NINE = 9;
    private int dice;

    public Dice() {
        this.dice = Randoms.pickNumberInRange(ZERO, NINE);
    }

    public int getDice() {
        return dice;
    }
}