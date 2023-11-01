package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validate.InputValidate;

public class InputView {

    private final InputValidate inputValidate;

    public InputView() {
        this.inputValidate = new InputValidate();
    }

    public String readNames() {
        String input = Console.readLine().trim();
        inputValidate.validateNames(input);
        return input;
    }

    public String readTrialNum() {
        String input = Console.readLine().trim();
        inputValidate.validateTrialNum(input);
        return input;
    }
}
