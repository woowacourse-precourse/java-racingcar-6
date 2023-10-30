package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int NumberGenrate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
