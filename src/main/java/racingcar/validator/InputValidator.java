package racingcar.validator;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    public static void validateSeparator(String input) {
        if (input.matches(".*[^,\\s^a-zA-Z0-9^[가-힣]*$].*")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
        }
    }
}
