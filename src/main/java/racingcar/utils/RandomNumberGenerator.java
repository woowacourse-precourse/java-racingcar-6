package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.GameCondition;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        int start = GameCondition.RANDOM_NUMBER_START_INCLUSIVE.getValue();
        int end = GameCondition.RANDOM_NUMBER_END_INCLUSIVE.getValue();
        return Randoms.pickNumberInRange(start, end);
    }
}
