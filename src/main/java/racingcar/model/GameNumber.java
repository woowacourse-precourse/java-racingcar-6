package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GameNumber {
    private static final int RANDOMNUMBER_START = 0;
    private static final int RANDOMNUMBER_END= 9;
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOMNUMBER_START, RANDOMNUMBER_END);
    }
}
