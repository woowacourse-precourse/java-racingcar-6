package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER_SIZE = 0;
    private static final int MAX_NUMBER_SIZE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_SIZE, MAX_NUMBER_SIZE);
    }
}
