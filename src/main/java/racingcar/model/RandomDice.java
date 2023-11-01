package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDice implements Dice {

    private static final int START_RANDOM = 0;
    private static final int END_RANDOM = 9;

    @Override
    public int roll() {
        return Randoms.pickNumberInRange(START_RANDOM, END_RANDOM);
    }

}
