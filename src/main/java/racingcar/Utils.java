package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static boolean isTrueWithProbability60Percent() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
