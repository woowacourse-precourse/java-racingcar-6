package racingcar.Validator;

public class Validator {

    public static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백이 존재합니다.");
        }
    }

}
