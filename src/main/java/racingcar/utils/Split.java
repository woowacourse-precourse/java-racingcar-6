package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Split {

    public static List<String> splitString(String input) {
        return Arrays.asList(input.split(","));
    }

}
