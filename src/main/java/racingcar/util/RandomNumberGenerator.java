package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(Constants.START_INCLUSIVE, Constants.END_INCLUSIVE);
    }
}
