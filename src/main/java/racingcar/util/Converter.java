package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private static final String COMMA = ",";

    public static List<String> convertCommaSeparatedStringToList(final String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .toList();
    }
}
