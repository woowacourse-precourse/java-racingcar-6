package racingcar.domain;

public class RacingMachine {

    private static final int MIN_TRY_COUNT = 1;

    private final Cars cars;
    private int tryCount;

    public RacingMachine(Cars cars, int tryCount) {
        validateTryCount(tryCount);
        this.cars = cars;
        this.tryCount = tryCount;
    }
    
    private void decreasedTryCount() {
        tryCount--;
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1보다 작으면 안됩니다.");
        }
    }
}
