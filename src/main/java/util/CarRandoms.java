package util;

import static racingcar.Constants.MAX_RANDOM_NUMBER;
import static racingcar.Constants.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRandoms {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
