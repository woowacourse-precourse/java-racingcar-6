package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

public class InputView {

    public String readInput() {
        String input = Console.readLine();
        validate(input);
        return input;
    }

    private void validate(final String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateNull(input);
    }

}
