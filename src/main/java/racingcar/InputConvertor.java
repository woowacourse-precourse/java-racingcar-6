package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    public static List<String> toList(String inputCarNames) {
        return Arrays.asList(inputCarNames.split(","));
    }

    public static int toInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
