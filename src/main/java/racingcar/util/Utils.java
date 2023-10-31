package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import racingcar.constant.NumberConstant;

public class Utils {
    public static boolean isNaturalNumber(String number) {
        if (isInteger(number)) {
            return isPositive(Integer.parseInt(number));
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

    public static boolean hasDuplicateMember(String[] array) {
        HashSet<String> set = new HashSet<String>();
        Collections.addAll(set, array);
        return array.length > set.size();
    }

    public static boolean isPositive(int integer) {
        return integer > 0;
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(NumberConstant.MIN_RANDOM_RANGE, NumberConstant.MAX_RANDOM_RANGE);
    }
}
