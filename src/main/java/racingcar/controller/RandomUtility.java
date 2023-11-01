package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtility {
    private static final int RACE_RANDOM_NUMBER_RANGE_START = 0;
    private static final int RACE_RANDOM_NUMBER_RANGE_END = 9;

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(RACE_RANDOM_NUMBER_RANGE_START, RACE_RANDOM_NUMBER_RANGE_END);

        return randomNumber;
    }
}
