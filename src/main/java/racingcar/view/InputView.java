package racingcar.view;

import static racingcar.enums.Message.CAR_NAME_INPUT_PROMPT;
import static racingcar.enums.Message.TRIAL_COUNT_INPUT_PROMPT;
import static racingcar.util.ValidationUtils.validateCarNames;
import static racingcar.util.ValidationUtils.validateTrialCount;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.PrintUtils;

public class InputView {
    public String getInputCarNames() {
        PrintUtils.printMessage(CAR_NAME_INPUT_PROMPT);
        String input = Console.readLine();
        validateCarNames(input);
        return input;
    }

    public String getInputTrialCount() {
        PrintUtils.printMessage(TRIAL_COUNT_INPUT_PROMPT);
        String input = Console.readLine();
        validateTrialCount(input);
        return input;
    }

    public void close() {
        Console.close();
    }
}
