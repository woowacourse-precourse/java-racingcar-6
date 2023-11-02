package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {

    public static List<String> convertStringToList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static String removeSpace(String input) {
        return input.replaceAll("\\s", "");
    }

}
