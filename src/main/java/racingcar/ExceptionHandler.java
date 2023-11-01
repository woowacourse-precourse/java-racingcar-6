package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class ExceptionHandler {
    public static List<String> checkNameLength(List<String> input) {
        for(String name : input) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
        return input;
    }

    public static List<String> checkEmpty(List<String> input) {
        for(String name : input) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름이 없는 입력입니다.");
            }
        }
        return input;
    }

    public static void checkNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    public static void checkNaturalNumber(String input) {
        String regex = "^[1-9]\\d*$";
        if(!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException("시도 횟수는 자연수만 가능합니다.");
        }
    }
}
