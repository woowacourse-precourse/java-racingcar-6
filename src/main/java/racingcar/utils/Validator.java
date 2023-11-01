package racingcar.utils;

import static racingcar.utils.RacingConfig.MAX_NAME_LENGTH;
import static racingcar.utils.RacingConfig.NAME_PATTERN;
import static racingcar.utils.RacingConfig.NAME_SEPARATOR;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Validator {
    private Validator() {
        throw new AssertionError("Validator class should not be instantiated.");
    }

    public static void validLength(String inputName) {
        if (Objects.isNull(inputName) || inputName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("5자 이하의 한글 또는 영어를 입력해주세요");
        }
    }

    public static void validNameFormat(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        if (!Pattern.matches(NAME_PATTERN, input)) {
            throw new IllegalArgumentException("이름은 한글과 영어, 구분자는 쉼표를 입력해주세요.");
        }
    }

    public static void validSingleName(String input) {
        String[] names = input.split(NAME_SEPARATOR);
        if (names.length < 2) {
            throw new IllegalArgumentException("경주할 자동차 이름을 2개 이상 입력해주세요");
        }
    }

    public static void validIsNumber(String inputNumber) {
        if (Objects.isNull(inputNumber) || inputNumber.trim().isEmpty() || !inputNumber.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void validNotZero(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (Objects.equals(number, 0)) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }
}
