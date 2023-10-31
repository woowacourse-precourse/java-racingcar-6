package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
