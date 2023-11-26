package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> convertToList(String input) {
        String[] array = input.split(",");
        return Arrays.asList(array);
    }

    public static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
