package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static int stringToInt(String strInput) {
        return Integer.parseInt(strInput);
    }

    public static List<String> stringToStringList(String strInput) {
        return Arrays.asList(strInput.split(","));
    }



}
