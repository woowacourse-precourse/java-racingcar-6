package racingcar.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public final class Utils {

    public static int generateRandomNumber() {
        return pickNumberInRange(0,9);
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

    public static boolean isEqualArray(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
}
