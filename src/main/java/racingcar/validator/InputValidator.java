package racingcar.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validateCarsFormat(String input) {
        // 정규식 패턴: 문자 또는 쉼표 외의 문자가 하나이상 있는지 확인
        Pattern pattern = Pattern.compile("[^a-zA-Z,]+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 입력에 허용되지 않는 문자가 포함되어있어요.");
        }
    }

    public static void validateCarLength(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 작성해주세요.");
            }
        }
    }

    public static void validateTryNumber(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 올바른 시도 횟수를 입력해주세요.");
        }
    }
}