package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

public final class InputView {

    private InputView() {
    }

    public static String readInput() {
        String input = Console.readLine();
        InputValidator.validate(input);
        return input;
    }

}
