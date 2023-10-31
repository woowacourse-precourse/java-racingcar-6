package racingcar.domain;

import camp.nextstep.edu.missionutils.*;

public class RandomNumberGenerator {
    private static final int MIN_VAL = 0;
    private static final int MAX_VAL = 9;

    private int randomNumber() {
        return Randoms.pickNumberInRange(MIN_VAL, MAX_VAL);
    }

}
