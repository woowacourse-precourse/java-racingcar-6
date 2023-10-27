package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static final Integer MAX_VALUE = 9;
    public static final Integer MIN_VALUE = 0;

    public static Integer generate() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}
