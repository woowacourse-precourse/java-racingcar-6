package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ParserUtils {
    public static List<String> namesParser(String input) {
        String[] nameArray = input.split(",");
        return Arrays.asList(nameArray);
    }
}
