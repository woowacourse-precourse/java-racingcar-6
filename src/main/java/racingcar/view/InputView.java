package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidator;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputTryCount() {
        String input = Console.readLine();
        checkTryCount(input);
        return input;
    }

    public String inputCarNames() {
        String input = Console.readLine();
        checkEmptyAndBlank(input);
        return input;
    }

    private void checkTryCount(String input) {
        inputValidator.validateTryCount(input);
    }

    private void checkEmptyAndBlank(String input) {
        inputValidator.validateInputEmpty(input);
        inputValidator.validateInputBlank(input);
    }
}
