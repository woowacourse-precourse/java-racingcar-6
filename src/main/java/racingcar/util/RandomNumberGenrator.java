package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenrator implements NumberGenrator{
    private final static int RANDOM_NUMBER_MIN_RANGE = 0;
    private final static int RANDOM_NUMBER_MAX_RANGE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE,RANDOM_NUMBER_MAX_RANGE);
    }
}
