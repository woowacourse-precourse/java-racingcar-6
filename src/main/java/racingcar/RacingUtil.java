package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingUtil {
    public static int generateRandomPower() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
