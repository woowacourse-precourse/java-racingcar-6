package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarListEditor {
    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    private enum Regex {
        SPACE(" "), NO_SPACE("");
        private final String regex;
        Regex(String regex) {
            this.regex = regex;
        }
    }
}
