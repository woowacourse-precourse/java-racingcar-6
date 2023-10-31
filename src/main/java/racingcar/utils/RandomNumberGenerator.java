package racingcar.utils;

import static racingcar.constant.RacingGameConstants.MOVABLE_MAX;
import static racingcar.constant.RacingGameConstants.MOVABLE_MIN;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    public int generateInteger() {
        return generateRandomNumberInRange(MOVABLE_MIN, MOVABLE_MAX);
    }

    private int generateRandomNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
