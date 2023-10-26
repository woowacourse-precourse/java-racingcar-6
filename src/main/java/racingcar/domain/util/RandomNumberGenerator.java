package racingcar.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private final int minInclusive;
    private final int maxInclusive;

    public RandomNumberGenerator(int minInclusive, int maxInclusive) {
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
    }

    public int generate() {
        return Randoms.pickNumberInRange(minInclusive, maxInclusive);
    }
}
