package racingcar.view;

public class InputView {
    private final InputProvider consoleProvider;

    public InputView(InputProvider consoleProvider) {
        this.consoleProvider = consoleProvider;
    }

    public CarName readCarName() {
        return new CarName(consoleProvider.provide());
    }
}
