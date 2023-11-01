package racingcar.utils;

import static racingcar.utils.Constants.MAX_VALUE;
import static racingcar.utils.Constants.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int createRandomNumber() {
        return (Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
    }
}
