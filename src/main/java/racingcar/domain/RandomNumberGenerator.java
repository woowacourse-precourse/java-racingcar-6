package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public Integer createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
