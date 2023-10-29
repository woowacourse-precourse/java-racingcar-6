package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRandomNumber implements RandomNumber {

    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
