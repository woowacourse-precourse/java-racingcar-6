package racingcar.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int createInRange(final int startInclusive, final int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
