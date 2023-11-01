package racingcar.view;

public interface InputView {
    static InputView consoleInputView() {
        return new ConsoleInputView();
    }
    String askCarNames();
    String askRound();
}
