package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView{

    @Override
    public String readCarNames() {
        return Console.readLine();
    }

    @Override
    public String readRaceTime() {
        return Console.readLine();
    }
}
