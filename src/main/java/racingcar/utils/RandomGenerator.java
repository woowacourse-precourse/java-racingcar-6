package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;


public class RandomGenerator implements NumberGenerator {

    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
