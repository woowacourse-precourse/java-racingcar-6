package racingcar.view;

import racingcar.utils.RandomNumberGenerator;

public class ConsoleInputView implements InputView {
    private static ConsoleInputView instance;

    private ConsoleInputView() {}

    public static ConsoleInputView getInstance() {
        if (instance == null) {
            instance = new ConsoleInputView();
        }
        return instance;
    }

    @Override
    public String readCarNames() {
        return null;
    }

    @Override
    public int readGameRound() {
        return 0;
    }
}
