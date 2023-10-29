package racingcar.domain;

public class TryCountValidator {

    private final String tryCount;

    public TryCountValidator(String tryCount) {
        this.tryCount = tryCount;
        validateTryCountExists();
    }

    public void validateTryCountExists() {
        if (tryCount.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
    }

}
