package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class NameHandler {

    public static List<String> splitNames(String in) {
        return Arrays.asList(in.split(",", -1));
    }

}
