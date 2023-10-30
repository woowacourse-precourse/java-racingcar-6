package racingcar.util;

import java.util.Collections;
import java.util.List;

public class Utils {

    private Utils() {
        throw new AssertionError("인스턴스화 불가능");
    }

    public static List<String> parseCarName(String input) {
        return List.of(input.split(","));
    }

    public static Integer findMaxInteger(List<Integer> list) {
        return Collections.max(list);
    }

}
