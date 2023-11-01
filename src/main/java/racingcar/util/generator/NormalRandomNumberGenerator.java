package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class NormalRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
