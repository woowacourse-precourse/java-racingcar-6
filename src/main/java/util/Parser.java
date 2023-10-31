package util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> splitCarNames(String inputLineOfCarNames) {
        return Arrays.asList(inputLineOfCarNames.split(","));
    }
}
