package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRandomNumberGenerator implements RandomNumberGenerator {

    private static final int START_VALUE = 0;
    private static final int END_VALUE = 9;

    @Override
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(START_VALUE, END_VALUE);
    }
}
