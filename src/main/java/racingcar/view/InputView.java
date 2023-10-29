package racingcar.view;

import racingcar.domain.model.AttemptsNumber;
import racingcar.domain.model.Cars;

public class InputView {
    private final InputProvider consoleProvider;

    public InputView(InputProvider consoleProvider) {
        this.consoleProvider = consoleProvider;
    }

    public Cars readCarNames() {
        return new Cars(consoleProvider.provide());
    }

    public AttemptsNumber readAttemptsNumber() {
        return new AttemptsNumber(consoleProvider.provide());
    }

}
