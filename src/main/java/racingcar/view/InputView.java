package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.InputValidation;

public class InputView {

    public static List<String> inputCarName() {
        String input = Console.readLine();
        List<String> carNames = InputValidation.validateNameAndSplit(input);
        InputValidation.validateNameList(carNames);
        return carNames;
    }

    public static int inputTryCount() {
        OutputView.printRequestNumberOfAttemptsMessage();
        String input = Console.readLine();
        OutputView.printExecutionResultMessage();
        return InputValidation.validateIsNumber(input);
    }
}
