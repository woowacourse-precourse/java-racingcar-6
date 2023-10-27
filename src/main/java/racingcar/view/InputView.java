package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

public class InputView {

    InputValidation inputValidation;
    public static String getPlayerInput() {
        String input = Console.readLine();
        splitWithComma(input);
        return input;
    }

    private static void splitWithComma(String input) {
        String[] splits = input.split(",");
        for (String split : splits) {
            new InputValidation(split);
        }
    }
}
