package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameConstant;

public class Util {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(GameConstant.MIN_RANDOM_NUMBER.getValue(),
                GameConstant.MAX_RANDOM_NUMBER.getValue());
    }
}
