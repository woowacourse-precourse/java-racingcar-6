package racingcar.validator;

public class Validator {
    public static void validateUnderFiveLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해야 합니다.");
        }
    }
}
