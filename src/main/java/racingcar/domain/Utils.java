package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import javax.swing.plaf.TreeUI;

public class Utils {
    public static boolean isNaturalNumber(String number) {
        if (isInteger(number)) {
            return isIntegerOverThanZero(Integer.parseInt(number));
        }
        return false;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isIntegerOverThanZero(int integer) {
        return integer > 0;
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
