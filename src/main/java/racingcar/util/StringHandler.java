package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringHandler {

    public static List<String> stringToList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static <T> String listToString(List<T> input) {
        return input.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    public static int stringToInt(String input) {
        try {
            int output = Integer.parseInt(input);
            return output;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해야합니다");
        }
    }
}
