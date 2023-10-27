package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.PlayerValidation;
import racingcar.validation.TryNumberValidation;

public class InputView {

    PlayerValidation inputValidation;
    public static String getPlayerInput() {
        String input = Console.readLine();
        splitWithComma(input);
        return input;
    }

    public static int getTryNumberInput() {
        String input = Console.readLine();
        new TryNumberValidation(input);
        int parsedInput = Integer.parseInt(input);
        return parsedInput;
    }

    private static void splitWithComma(String input) {
        String[] splits = input.split(",");
        for (String split : splits) {
            new PlayerValidation(split);
        }
    }
}
