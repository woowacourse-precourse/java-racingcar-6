package racingcar.domain;

public record TryCount(int value) {

    private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 0보다 작거나, 1000보다 클 수 없습니다.";
    private static final int MIN_TRY_COUNT = 0;
    private static final int MAX_TRY_COUNT = 1000;

    public TryCount {

        if (value < MIN_TRY_COUNT || value > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
