package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

    public static List<String> getSplitTokensFrom(String s) {
        String[] split = s.split(",");
        return Arrays.asList(split);
    }

}
