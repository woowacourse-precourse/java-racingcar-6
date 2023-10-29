package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    public static int generateRandomNumber() {

        return Randoms.pickNumberInRange(0, 9);
    }
}
