package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public static int chooseRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
