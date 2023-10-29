package racingcar.domain;

public class TryCountValidator {

    private final String tryCount;

    public TryCountValidator(String tryCount) {
        this.tryCount = tryCount;
        validateTryCountExists();
        validateTryCountIsInteger();
        validateTryCountIsPositive();
    }

    public void validateTryCountExists() {
        if (tryCount.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
    }

    public void validateTryCountIsInteger() {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
    }

    public void validateTryCountIsPositive() {
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수여야 합니다.");
        }
    }

}
