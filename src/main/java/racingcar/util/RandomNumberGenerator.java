package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private final int GENERATE_MIN = 0;
    private final int GENERATE_MAX = 9;

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(GENERATE_MIN, GENERATE_MAX);
    }
}
