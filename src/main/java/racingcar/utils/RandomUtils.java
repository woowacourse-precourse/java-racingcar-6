package racingcar.utils;

import static racingcar.global.constants.NumberType.MAX_RANDOM_NUMBER;
import static racingcar.global.constants.NumberType.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomUtils {
    public static Integer generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue());
    }
}