package racingcar.manager;

import static racingcar.constant.InputStringConstant.INPUT_NAME_DIVIDER;
import static racingcar.utils.validate.InputValidator.validateName;

import java.util.Arrays;
import racingcar.utils.dto.Names;
import racingcar.utils.validate.GameValidator;
import racingcar.utils.validate.InputValidator;
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
        String inputString = input.getNames();
        InputValidator.validateInput(inputString);
        String[] inputNames = inputString.split(INPUT_NAME_DIVIDER.getValue());
        validateName(inputNames);
        GameValidator.validateDuplicatedName(inputNames);
        return new Names(Arrays.stream(inputNames).toList());
    }

    public int getRoundNum() {
        String roundNumStr = input.getRound();
        InputValidator.validateRoundNum(roundNumStr);
        int roundNum = Integer.parseInt(roundNumStr);
        GameValidator.validateRoundNum(roundNum);
        return roundNum;
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
