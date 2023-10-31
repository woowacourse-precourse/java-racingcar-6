package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public final class Utils {
    public static int randomNumberGenerator() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
