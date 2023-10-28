package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static List<String> splinter(String name) {
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }
    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 수 오류");
        }
    }
}
