package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringHandler {

    public static List<String> separatedStringToList(String input, String splitter) {
        return Arrays.stream(input.split(splitter)).toList();
    }

    public static <T> String listToStringSplitBy(List<T> input, String splitter) {
        return input.stream()
                .map(Object::toString)
                .collect(Collectors.joining(splitter));
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
