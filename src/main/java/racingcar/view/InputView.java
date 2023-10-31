package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ConsoleMessage;
import racingcar.util.Constants;
import racingcar.util.Validator;

public class InputView {
    public static String[] inputCarName() {
        OutputView.printlnConsoleMessage(ConsoleMessage.INPUT_CAR_NAME);
        String[] inputs = splitByComma(Console.readLine());
        return Validator.isValidCarName(inputs);
    }

    public static int inputAttemptCount() {
        OutputView.printlnConsoleMessage(ConsoleMessage.INPUT_ATTEMPT_COUNT);
        String input = Validator.isValidAttemptCount(Console.readLine());
        return Integer.parseInt(input);
    }

    public static String[] splitByComma(String input) {
        Validator.isValidInput(input);
        return input.split(Constants.COMMA);
    }
}
