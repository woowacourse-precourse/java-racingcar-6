package racingcar;

import java.util.Arrays;
import java.util.List;

public class GameUtil {
    public static List<String> splitByCommas(String target) {
        return Arrays.asList(target.split(","));
    }
}
