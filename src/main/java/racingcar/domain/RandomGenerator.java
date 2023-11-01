package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
    }
}
