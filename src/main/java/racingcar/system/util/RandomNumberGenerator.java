package racingcar.system.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int START_NUMBER = 0;
    public static final int END_NUMBER = 9;

    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
