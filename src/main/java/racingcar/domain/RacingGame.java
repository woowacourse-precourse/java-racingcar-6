package racingcar.domain;

public class RacingGame {

    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final String ATTEMPT_COUNT_INIT_ERROR_MESSAGE = "최소 1회의 시도 횟수를 입력해 주세요.";

    Cars cars;
    int attemptCount;

    public RacingGame(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        validateMinAttemptCount();
    }

    private void validateMinAttemptCount() {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_INIT_ERROR_MESSAGE);
        }
    }

    public boolean isEnd() { return attemptCount <= END_COUNT; }

    public void proceed() {
        if (isEnd()) {
            return;
        }
        cars.moveCars();
        attemptCount--;
    }

}
