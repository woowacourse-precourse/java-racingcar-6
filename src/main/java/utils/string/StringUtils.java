package utils.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    private StringUtils() {
    }

    public static List<String> parseCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int parseNumberOfCount(String input) {
        return Integer.parseInt(input);
    }

}
