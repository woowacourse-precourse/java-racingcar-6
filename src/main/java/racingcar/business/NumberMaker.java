package racingcar.business;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {

    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 9;

    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

}
