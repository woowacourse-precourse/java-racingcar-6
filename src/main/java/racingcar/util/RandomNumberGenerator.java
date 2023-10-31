package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements Generator {

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
