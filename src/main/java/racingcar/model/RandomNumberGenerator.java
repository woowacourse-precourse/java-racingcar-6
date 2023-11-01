package racingcar.model;

import static racingcar.utils.Constants.END_RANDOM_NUMBER;
import static racingcar.utils.Constants.START_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int makeNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }
}
