package racingcar.validator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    public static void stringsLengthInRange(List<String> strings, int minSize, int maxSize) {
        for (String string : strings) {
            stringLengthInRange(string, minSize, maxSize);
        }
    }

    public static void stringLengthInRange(String string, int minSize, int maxSize) {
        if (string.length() < minSize || string.length() > maxSize) {
            throw new IllegalArgumentException("문자열의 길이가 범위 내에 속하지 않습니다");
        }
    }

    //에러메세지를 constant로 묶어서 매개변수로 받아서쓰는것
    //일일이 메시지를 정해준다면 정해진 게임에서의 정확한 에러를 찾기 힘들다.
    //예를 들어서 문자열 리스트 중에 중복된 문자열이 존재합니다.
    //를 자동차 이름들중 중복된 값이 존재합니다. 로 변경
    public static void stringsNotDuplicated(List<String> strings) {
        long count = strings.stream().distinct().count();
        if (strings.size() != count) {
            throw new IllegalArgumentException("문자열 리스트 중에 중복된 문자열이 있습니다.");
        }
    }

    public static void stringsContainsOnlyRegex(List<String> strings, String regex) {
        for (String string : strings) {
            stringContainsOnlyRegex(string, regex);
        }
    }

    public static void stringContainsOnlyRegex(String string, String regex) {
        if (!Pattern.matches(regex, string)) {
            throw new IllegalArgumentException("정해진 정규식을 벗어났습니다.");
        }

    }
}
