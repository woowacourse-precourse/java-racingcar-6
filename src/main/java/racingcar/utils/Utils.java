package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public final class Utils {

    public static int generateRandomNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0,9);
    }

    public static int measureMaxNumInHashMapValues(HashMap<String,String> hashMap) {
        return Collections.max(hashMap.values()).length();
    }

    public static String[] splitByComma(String string) {
        return string.split(",");
    }

    public static String[] splitByCommaAndBlank(String string) {
        return string.split("\\s*,\\s*");
    }
}
