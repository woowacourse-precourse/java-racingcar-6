package racingcar.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
