package racingcar.business;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {

    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
