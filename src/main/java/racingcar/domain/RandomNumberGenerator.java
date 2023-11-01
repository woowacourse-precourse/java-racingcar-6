package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int pickNumberInRange(int startInclusive, int endExclusive) {
        return Randoms.pickNumberInRange(startInclusive, endExclusive);
    }
}
