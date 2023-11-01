package racingcar.model.rule;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator implements GameRule{
    public static Integer getRandomNUmber() {
        return Randoms.pickNumberInRange(MIN_RANGE_VALUE, MAX_RANGE_VALUE);
    }
}
