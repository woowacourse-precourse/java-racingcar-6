package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validateInputFormat(String input) {
        Pattern pattern = Pattern.compile(Constant.CAR_NAMES_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 영어 또는 한글만 가능합니다. 쉼표(,)로 구분하여 두 대 이상 입력해주세요.");
        }
    }

    public static void validateInputIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 숫자를 입력해주세요.");
        }
    }

    public static void validateInputInRange(String input) {
        int tryCount = Integer.parseInt(input);
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
        }
    }
}