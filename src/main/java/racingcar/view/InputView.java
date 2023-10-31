package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCarNames() {
        OutputView.printInputCarNames();
        return Console.readLine();
    }

    public static String readNumber() {
        OutputView.printInputNumber();
        return Console.readLine();
    }
}
