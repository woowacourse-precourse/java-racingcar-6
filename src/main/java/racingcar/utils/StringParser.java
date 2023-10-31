package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private StringParser() {} //인스턴스화 방지

    public static List<String> splitCarNames(String carNames) {
       String[] carNamesArr = carNames.split(",");
       return Arrays.asList(carNamesArr);
    }
}
