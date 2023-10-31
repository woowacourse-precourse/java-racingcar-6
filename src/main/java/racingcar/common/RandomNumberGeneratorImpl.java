package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    private static final int MAX_NUMBER=9;
    private static final int MIN_NUMBER=0;
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }
}