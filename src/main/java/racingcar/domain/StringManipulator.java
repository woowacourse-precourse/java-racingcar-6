package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringManipulator {
    public static List<String> split(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String join(List<String> parts) {
        return parts.stream()
                .map(String::trim)
                .collect(Collectors.joining(","));
    }
}
