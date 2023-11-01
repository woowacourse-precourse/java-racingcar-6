package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingRandomNumberGenerator implements NumberGenerator {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    @Override
    public int createInRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
