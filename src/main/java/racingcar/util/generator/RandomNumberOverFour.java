package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberOverFour implements RandomNumberGenerator {
    @Override
    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(4, 9);
    }
}
