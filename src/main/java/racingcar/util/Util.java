package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.UtilConstant;

public class Util {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(UtilConstant.MIN_RANDOM_NUMBER.getValue(),
                UtilConstant.MAX_RANDOM_NUMBER.getValue());
    }

    public static String readLine() {
        return Console.readLine();
    }
}
