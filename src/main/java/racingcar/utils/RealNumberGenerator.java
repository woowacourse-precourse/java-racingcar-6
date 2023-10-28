package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RealNumberGenerator implements NumberGenerator {
    @Override
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
