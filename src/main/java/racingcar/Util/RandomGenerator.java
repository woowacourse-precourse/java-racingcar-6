package racingcar.Util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

}
