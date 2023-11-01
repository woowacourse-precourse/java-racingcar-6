package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNumber {
    public static final int RANDOM_NUMBER_RANGE_START = 0;
    public static final int RANDOM_NUMBER_RANGE_END = 9;

    public static int getNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
    }
}
