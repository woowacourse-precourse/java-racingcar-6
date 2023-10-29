package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputValidator;

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
        String names = Console.readLine();
        InputValidator.validateInputNames(names);
        return names;
    }

    @Override
    public int readGameRound() {
        String round = Console.readLine();
        InputValidator.validateInputRound(round);
        return Integer.parseInt(round);
    }
}
