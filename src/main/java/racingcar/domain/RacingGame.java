package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private static final int ZERO = 0;
    private int tryCount;
    private Cars cars;

    public RacingGame() {
        cars = new Cars();
    }

    public void start() {
        String namesFromUser = InputView.getNamesFromUser();
        String[] names = InputView.validateNames(namesFromUser);
        cars.addCarsFromNames(names);

        String tryCountFromUser = InputView.getTryCountFromUser();
        tryCount = InputView.validateTryCount(tryCountFromUser);

        OutputView.printTryResult();
        tryEachCount();

        String winners = cars.findWinners();
        OutputView.printWinners(winners);
    }

    private void tryEachCount() {
        while (!isTryCountZero()) {
            cars.tryMovements();
            tryCount--;
        }
    }

    private boolean isTryCountZero() {
        return tryCount == ZERO;
    }
}