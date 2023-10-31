package racingcar.controller.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<String> splitCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // 정수로 변환할 수 없는 경우 예외 처리
            return 0; // 또는 다른 기본값을 반환하거나 예외를 던질 수 있습니다.
        }
    }
}
