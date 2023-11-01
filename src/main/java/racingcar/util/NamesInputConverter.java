package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class NamesInputConverter {

    private NamesInputConverter() {
    }

    public static List<String> convertToNames(String input) {
        return Arrays.stream(input.split(","))
            .filter(NamesInputConverter::isNotEmpty)
            .filter(NamesInputConverter::isNotBlank)
            .toList();
    }

    private static boolean isNotEmpty(String name) {
        return !name.isEmpty();
    }

    private static boolean isNotBlank(String name) {
        return !name.isBlank();
    }
}
