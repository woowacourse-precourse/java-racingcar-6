package racingcar.model;

import java.util.List;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.IntGenerator;
import racingcar.model.winnerstrategy.MaximumForwardStrategy;

public class Racing {
    private static final int ONE_MOVE = 1;
    private int tryCount;
    private final Cars cars;

    public Racing(List<String> carNames, int tryCount, IntGenerator intGenerator) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        this.cars = Cars.fromNames(carNames, intGenerator);
    }

    public boolean canMove() {
        return tryCount > 0;
    }

    public void doMove() {
        cars.move();
        countMove();
    }

    public List<CarState> captureCurrentState() {
        return cars.collectAllState();
    }

    public List<String> generateWinnerNames() {
        RacingResult racingResult = new RacingResult(cars, new MaximumForwardStrategy());
        return racingResult.judgeWinnerNames();
    }

    private void countMove() {
        tryCount -= ONE_MOVE;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorCode.NON_POSITIVE_TRY_COUNT.getMessage());
        }
    }
}
