package racingcar.domain;

import camp.nextstep.edu.missionutils.*;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int MIN_VAL = 0;
    private static final int MAX_VAL = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_VAL, MAX_VAL);
    }

}
