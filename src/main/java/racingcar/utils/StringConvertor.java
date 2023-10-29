package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {

    public static List<String> convertStringToList(String number) {
        return Arrays.stream(number.split(",")).toList();
    }

    public static int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

}
