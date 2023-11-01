package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {

    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;

    private NumberMaker() {
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }
}
