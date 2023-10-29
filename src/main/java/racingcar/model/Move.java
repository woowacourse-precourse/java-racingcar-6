package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {
    private static final int RANDOM_NUM_START = 0;
    private static final int RANDOM_NUM_END = 9;
    public int generateRandom() {
        int randomNum = Randoms.pickNumberInRange(RANDOM_NUM_START,RANDOM_NUM_END);
        return randomNum;
    }
}
