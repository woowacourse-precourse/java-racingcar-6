package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public static List<String> splitAndStrip(String input) {
        return strip(Arrays.asList(split(input)));
    }

    private static String[] split(String input) {
        return input.split(",");
    }

    private static List<String> strip(List<String> splitedInput) {
        splitedInput.replaceAll(String::strip);
        return splitedInput;
    }
}
