package racingcar.validation;

public class InputValidation {

    public static void nameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 지어야 합니다.");
        }
    }

    public static void isNumber(String input) {
        int number;

        try {
            number = Integer.parseInt(input);

        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 값만 입력해야 합니다.");
        }

        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 횟수를 입력해야 합니다.");
        }
    }
}
