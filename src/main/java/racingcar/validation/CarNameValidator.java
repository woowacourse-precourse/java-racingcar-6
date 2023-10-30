package racingcar.validation;

public class CarNameValidator {
    public static void validate(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("자동차 이름은 6자 이상일 수 없습니다.");
        }
    }
}
