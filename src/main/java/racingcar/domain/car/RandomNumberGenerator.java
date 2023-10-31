package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements Generator {
    @Override
    public int generate(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
