package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {

    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
    }
}