package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static String[] getCarNames() {
        String input = InputView.userInput();
        return input.split(",");
    }
}
