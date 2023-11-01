package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
