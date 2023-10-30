package racingcar.util.number;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public static int getRandomNumber() {
        int randomNumber = 0;
        randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        return randomNumber;
    }
}
