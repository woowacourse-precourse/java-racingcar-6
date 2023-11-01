package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarName() {
        OutputView.printInputCarNameMessage();
        return Console.readLine();
    }

    public int getTryNumber() {
        OutputView.printInputTryNumber();
        return Integer.parseInt(Console.readLine());
    }
}

