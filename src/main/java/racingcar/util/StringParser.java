package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> toCarNameList(String input) {
        String[] nameArray = input.split(",");
        return Arrays.asList(nameArray);
    }

    public static int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
