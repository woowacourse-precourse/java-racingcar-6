package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<String> toList(String before) {
        return Arrays.stream(before.replaceAll(" ", "")
                        .split(","))
                .collect(Collectors.toList());
    }

    public static int toInteger(String before) throws IllegalArgumentException {
        Validator.validateDigit(before);
        return Integer.parseInt(before);
    }
}
