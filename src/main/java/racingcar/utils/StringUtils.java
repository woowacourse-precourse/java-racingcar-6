package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(",")); // 한줄에 점하나만 찍는다 검증.
    }
}