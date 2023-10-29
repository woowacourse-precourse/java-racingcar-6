package racingcar.domain;

import racingcar.constant.IllegalArgumentExceptionType;

public class RacingGame {
    private static final int END_COUNT = 0;

    private final Cars cars;
    private int attemptCount;

    public RacingGame(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        validateMinAttemptCount();
    }

    private void validateMinAttemptCount() {
        if (isEnd()) {
            throw IllegalArgumentExceptionType.ATTEMPT_COUNT_INIT_ERROR_MESSAGE.getException();
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

    public RacingGameState getCurrentState() {
        return new RacingGameState(isEnd(), cars.cars());
    }
}
