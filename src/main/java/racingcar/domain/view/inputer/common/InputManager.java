package racingcar.domain.view.inputer.common;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String getInput() {
        String userInput = Console.readLine();
        return InputManager.removeSpace(userInput);
    }

    private static String removeSpace(String input) {
        return input.replace(" ", "");
    }
}
