package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomNumberGenerator {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public int generateUniqueNumbers() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}

