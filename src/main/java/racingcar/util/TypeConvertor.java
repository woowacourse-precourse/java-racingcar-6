package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.ExceptionMessage.NOT_NUMERIC;

public class TypeConvertor {

    private static final String REGEX = ",";

    public static List<String> stringToStringList(String input) {
        return Arrays.stream(input.split(REGEX))
                .collect(Collectors.toList());
    }

    public static Integer stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

}
