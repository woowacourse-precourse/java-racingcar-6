package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class Util {
    public static List<String> splitNameByComma(String names) {
        List<String> splits = Arrays.stream(names.split(",")).toList();
        return splits;
    }

    public static int convertStringToInt(String count) {
        int convert = Integer.parseInt(count);
        return convert;
    }

    public static boolean isEqual(int num1, int num2) {
        return num1 == num2;
    }
}

