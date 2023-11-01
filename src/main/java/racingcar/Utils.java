package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> splitByDelimiter(String str, String delimiter) {
        return Arrays.asList(str.split(delimiter));
    }

    public static boolean isTrueWithProbability60Percent() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
