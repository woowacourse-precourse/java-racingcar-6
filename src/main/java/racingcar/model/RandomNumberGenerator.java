package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public RandomNumber generate() {
        return new RandomNumber(Randoms.pickNumberInRange(0, 9));
    }
}