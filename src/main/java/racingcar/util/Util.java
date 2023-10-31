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
        try {
            int convert = Integer.parseInt(count);
            return convert;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도할 회수는 숫자로만 입력할 수 있습니다.");
        }
    }

    public static boolean isEqual(int num1, int num2) {
        return num1 == num2;
    }
}

