package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int STARTING_RANGE = 1;
    private static final int END_RANGE = 9;

    private RandomNumberGenerator(){}

    public static int generateRandomNumbers() {
        return Randoms.pickNumberInRange(STARTING_RANGE, END_RANGE);
    }

}
