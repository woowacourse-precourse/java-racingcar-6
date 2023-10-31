package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.domain.PlayIterator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    // Constructor for singleton pattern
    private Race() {
    }

    // Getter method for singleton pattern
    public static Race getInstance() {
        return LazyHolder.INSTANCE;
    }

    // Inner class with lazy loading instance
    private static class LazyHolder {
        private static final Race INSTANCE = new Race();
    }

    public void start() {
        CarGroup carGroup = CarGroup.from(InputView.askCarNames());
        PlayIterator playIterator = PlayIterator.from(InputView.askPlayCount());

        OutputView.printResultTitle();
        while (playIterator.isPlayable()) {
            playIterator.play();
            carGroup.moveAllProbabilistically();
            OutputView.printStatus(carGroup.getStatusAsString());
        }
        OutputView.printWinner(carGroup.getWinnerAsString());
    }
}
