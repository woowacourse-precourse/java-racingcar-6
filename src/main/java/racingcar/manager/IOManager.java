package racingcar.manager;

import static racingcar.constant.InputStringConstant.INPUT_NAME_DIVIDER;
import static racingcar.validate.InputValidator.validateName;
import static racingcar.validate.InputValidator.validateRoundNum;

import java.util.Arrays;
import racingcar.view.Input;
import racingcar.view.Output;

public class IOManager {

    private final Input input;
    private final Output output;

    public IOManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public Names getNames() {
        String[] inputNames = input.getNames().split(INPUT_NAME_DIVIDER.getValue());
        validateName(inputNames);

        return new Names(Arrays.stream(inputNames).toList());
    }

    public int getRoundNum() {
        String roundNumStr = input.getRound();
        validateRoundNum(roundNumStr);
        return Integer.parseInt(roundNumStr);
    }

    public void printGameResultInit() {
        output.printGameResultInit();
    }

    public void printRoundResult(String roundResult) {
        output.printRoundResult(roundResult);
    }

    public void printWinner(Names names) {
        output.printWinner(names);
    }
}
