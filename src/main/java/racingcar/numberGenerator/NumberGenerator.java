package racingcar.numberGenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}
