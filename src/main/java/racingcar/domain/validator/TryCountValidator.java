package racingcar.domain.validator;

public class TryCountValidator {

    private final String tryCount;

    public TryCountValidator(String tryCount) {
        this.tryCount = tryCount;
        validateTryCountExists();
        validateTryCountIsInteger();
        validateTryCountIsPositive();
    }

    private void validateTryCountExists() {
        if (tryCount.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
    }

    private void validateTryCountIsInteger() {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
    }

    private void validateTryCountIsPositive() {
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수여야 합니다.");
        }
    }

}
