package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String receiveCarNames() {
        return Console.readLine();
    }

    @Override
    public String receivePlayCount() {
        return Console.readLine();
    }
}
