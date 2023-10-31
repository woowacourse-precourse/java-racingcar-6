package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeTransducer {

    public static List<String> strToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String listToString(List<String> input) {
        return String.join(", ", input);
    }

}
