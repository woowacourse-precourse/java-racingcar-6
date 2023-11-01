package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView extends InputView {
    @Override
    public String read() {
        final String readFromConsole = Console.readLine();
        return readFromConsole;
    }
}
