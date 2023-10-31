package racingcar.domain;

import java.util.List;

public class RacingMachine {

    private static final int MIN_TRY_COUNT = 1;

    private final Cars cars;
    private int tryCount;

    public RacingMachine(Cars cars, int tryCount) {
        validateTryCount(tryCount);
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void gamePlay(NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
        decreasedTryCount();
    }

    private void decreasedTryCount() {
        tryCount--;
    }

    public boolean canPlay() {
        return tryCount > 0;
    }

    public List<String> selectWinner() {
        return cars.getWinners();
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1보다 작으면 안됩니다.");
        }
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
