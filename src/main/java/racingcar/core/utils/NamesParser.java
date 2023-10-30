package racingcar.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesParser {
    public List<String> parsing(String stringNames){
        if (startCheck(stringNames) || endCheck(stringNames)
                || commaCheck(stringNames)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(stringNames.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }
    private static boolean commaCheck(final String stringNames) {
        return stringNames.contains(",,") || stringNames.contains(", ,");
    }
    private static boolean endCheck(final String stringNames) {
        return stringNames.endsWith(",") || stringNames.endsWith(", ");
    }
    private static boolean startCheck(final String stringNames) {
        return stringNames.startsWith(" ") || stringNames.startsWith(",");
    }
}
