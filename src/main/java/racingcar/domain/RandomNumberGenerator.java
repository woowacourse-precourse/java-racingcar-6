package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final Integer MAX_VALUE = 9;
    private static final Integer MIN_VALUE = 0;

    public static Integer generate() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}
