package racingcar.view;

public class InputView {
    private final InputProvider consoleProvider;

    public InputView(InputProvider consoleProvider) {
        this.consoleProvider = consoleProvider;
    }

    public CarNames readCarNames() {
        return new CarNames(consoleProvider.provide());
    }

}
