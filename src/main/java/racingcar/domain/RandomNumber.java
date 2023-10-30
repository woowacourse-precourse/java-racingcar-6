package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
