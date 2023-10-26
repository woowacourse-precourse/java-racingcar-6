package racingcar.validation;

public class InputValidation {

    public static void NameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 지어야 합니다.");
        }
    }
}
