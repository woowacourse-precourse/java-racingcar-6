package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConvertor {

    public static List<String> stringToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input format", e);
        }
    }
}
