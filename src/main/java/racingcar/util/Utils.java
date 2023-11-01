package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static int getMaxValue(List<Integer> integers) {
        return Collections.max(integers);
    }
}
