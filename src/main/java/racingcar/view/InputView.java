package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.validator.InputValidator;

public class InputView {
    public static String askCarName() {
        String input = Console.readLine();
        InputValidator.validateCarName(input);
        return input;
    }

    public static String askPlayTime() {

        String input = Console.readLine();
        InputValidator.validatePlayTime(input);
        return input;
    }
}
