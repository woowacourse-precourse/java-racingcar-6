package racingcar.validation;

public class AttemptValidator {
    public void validate(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
        if (!attempt.matches("\\d")) {
            throw new IllegalArgumentException("숫자 이외에 입력할 수 없습니다.");
        }
    }
}
