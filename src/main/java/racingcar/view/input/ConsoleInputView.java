package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String receiveCarNames() {
        return Console.readLine();
    }
}
