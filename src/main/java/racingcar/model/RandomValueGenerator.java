package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValueGenerator {

    public int getRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
