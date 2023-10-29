package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<String> parseStringList(String input) {
        String[] split = input.split(",", -1);
        List<String> result = new ArrayList<>();

        for (String string : split) {
            result.add(string);
        }

        return result;
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
