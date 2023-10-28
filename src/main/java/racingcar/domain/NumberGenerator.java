package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    protected NumberGenerator() {}
    public static Integer createRandomNumbers() {
        return Randoms.pickNumberInRange(0,9);
    }
}
