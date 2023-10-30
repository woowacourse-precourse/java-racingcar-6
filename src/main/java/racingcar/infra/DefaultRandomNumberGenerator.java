package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RandomNumberGenerator;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
