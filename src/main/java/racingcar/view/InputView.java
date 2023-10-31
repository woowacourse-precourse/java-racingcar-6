package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String inputNames() {
        OutputView.printNameInputMessage();

        return Console.readLine();
    }

    public static String inputRound() {
        OutputView.printRoundInputMessage();
        return Console.readLine();
    }
}
