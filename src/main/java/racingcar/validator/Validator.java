package racingcar.validator;

public class Validator {
    public static void validateUnderFiveLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해야 합니다.");
        }
    }

    public static void validateIsBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("자동차의 이름으로 공백은 사용할 수 없습니다.");
        }
    }
}
