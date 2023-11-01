package racingcar.model;

import static racingcar.model.GameRule.END_NUMBER;
import static racingcar.model.GameRule.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static int randomNumberGenerator() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

}
