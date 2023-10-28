package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static List<String> splinter(String names) {
        Validator.validateEndsWith(names);
        return Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }

    public static int parseInt(String str) {
        Validator.validatePositiveInteger(Integer.parseInt(str));
        return Integer.parseInt(str);
    }
}
