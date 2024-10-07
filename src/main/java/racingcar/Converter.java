package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<String> splitByDelimiter(String string, String delimiter) {
        String[] splitString = string.split(delimiter);
        List<String> strings = Arrays.stream(splitString).map(String::trim).collect(Collectors.toList());
        return strings;
    };
}
