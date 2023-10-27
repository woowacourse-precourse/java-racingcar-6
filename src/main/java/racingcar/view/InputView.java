package racingcar.view;

import racingcar.domain.model.AttemptsNumber;
import racingcar.domain.model.CarNames;

public class InputView {
    private final InputProvider consoleProvider;

    public InputView(InputProvider consoleProvider) {
        this.consoleProvider = consoleProvider;
    }

    public CarNames readCarNames() {
        return new CarNames(consoleProvider.provide());
    }

    public AttemptsNumber readAttemptsNumber() {
        return new AttemptsNumber(consoleProvider.provide());
    }

}
