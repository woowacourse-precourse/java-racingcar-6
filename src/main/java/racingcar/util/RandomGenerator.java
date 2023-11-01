package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public RandomGenerator() {
    }

    public int createRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
