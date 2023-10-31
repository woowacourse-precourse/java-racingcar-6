package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.enums.RaceConstant.MAX_RANDOM_NUMBER;
import static racingcar.enums.RaceConstant.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator {
    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getNumber(), MAX_RANDOM_NUMBER.getNumber());
    }
}
