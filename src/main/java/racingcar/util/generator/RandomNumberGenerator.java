package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements Generator<Integer> {

    private static final int NUMBER_RANGE_START = 0;
    private static final int NUMBER_RANGE_END = 0;

    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(NUMBER_RANGE_END, NUMBER_RANGE_END);
    }
}
