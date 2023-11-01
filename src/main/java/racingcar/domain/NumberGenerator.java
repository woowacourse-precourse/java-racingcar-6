package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int createRandomNumber() {
        final int MIN_RANGE = 0;
        final int MAX_RANGE = 9;
        int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        return randomNumber;
    }
}
