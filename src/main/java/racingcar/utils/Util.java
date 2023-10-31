package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> parseStringToListSplitComma(String paringString){
        return Arrays.asList(paringString.split(","));
    }
}
