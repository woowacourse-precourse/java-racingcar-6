package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {

    public static ArrayList<String> arrayList(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

}
