package racingcar.domain;

import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private static final int ZERO = 0;
    private int tryCount;
    private final Cars cars;

    public RacingGame() {
        cars = new Cars();
    }

    public void start() {
        String namesFromUser = InputView.getNamesFromUser();
        String[] names = Validator.validateNames(namesFromUser);
        cars.addCarsFromNames(names);

        String tryCountFromUser = InputView.getTryCountFromUser();
        tryCount = Validator.validateTryCount(tryCountFromUser);

        OutputView.printTryResult();
        tryEachCount();

        String winners = cars.findWinners();
        OutputView.printWinners(winners);
    }

    private void tryEachCount() {
        while (!isTryCountZero()) {
            cars.tryMovements();
            String updatedResult = OutputView.updatedResult(cars);
            OutputView.printUpdatedResult(updatedResult);
            tryCount--;
        }
    }

    private boolean isTryCountZero() {
        return tryCount == ZERO;
    }
}