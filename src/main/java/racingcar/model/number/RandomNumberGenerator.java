package racingcar.model.number;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
