package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtil {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
