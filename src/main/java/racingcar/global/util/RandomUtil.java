package racingcar.global.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static boolean trueOrFalse(int minNumber, int maxNumber, int minPassNumber) {
        int number = Randoms.pickNumberInRange(minNumber, maxNumber);
        return number >= minPassNumber;
    }
}
