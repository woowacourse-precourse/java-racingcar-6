package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ConverterUtil {

    public static List<String> covertStringToList(String str) {
        List<String> list = Arrays.asList(str.split(","));
        return list;
    }

}
