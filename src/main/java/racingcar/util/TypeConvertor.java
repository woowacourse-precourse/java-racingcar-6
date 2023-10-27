package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConvertor {

    public static List<String> stringToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
