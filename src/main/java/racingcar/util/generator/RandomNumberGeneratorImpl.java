package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    private final int MINIMUM_VALUE = 0;
    private final int MAXIMUM_VALUE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_VALUE, MAXIMUM_VALUE);
    }
}
