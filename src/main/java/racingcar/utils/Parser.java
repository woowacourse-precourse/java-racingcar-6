package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {

    // 각 자동차 명 사이에 쉼표를 기준으로 파싱
    public static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .toList();
    }
}
