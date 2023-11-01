package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(GameConstants.RANDOM_RANGE_MIN_NUMBER,
                GameConstants.RANDOM_RANGE_MAX_NUMBER);
    }
}
