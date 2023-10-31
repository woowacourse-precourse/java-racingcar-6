package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;


    public int createRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

}
