package racingcar.utils;

import static racingcar.domain.RacingConfig.MAX_LENGTH;
import static racingcar.domain.RacingConfig.NAME_PATTERN;

import java.util.regex.Pattern;

public final class Validator {

    private Validator() {
        throw new AssertionError("Validator class should not be instantiated.");
    }

    public static void isValidNameFormat(String input) {
        if (!Pattern.matches(NAME_PATTERN, input)) {
            throw new IllegalArgumentException("이름은 한글과 영어, 구분자는 쉼표를 입력해주세요.");
        }
    }

    public static void isValidLength(String inputName) {
        if (inputName.length() > MAX_LENGTH){
            throw new IllegalArgumentException("5자 이하의 한글 또는 영어를 입력해주세요");
        }
    }

    public static void isNumber(String inputNumber) {
        if (!inputNumber.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
