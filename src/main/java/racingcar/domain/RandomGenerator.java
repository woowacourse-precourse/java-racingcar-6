package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
