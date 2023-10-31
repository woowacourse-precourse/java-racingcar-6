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
}
