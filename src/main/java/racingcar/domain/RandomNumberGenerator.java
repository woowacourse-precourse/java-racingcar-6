package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MINIMAL_NUMBER = 4;

    @Override
    public boolean generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MINIMAL_NUMBER;
    }
}
