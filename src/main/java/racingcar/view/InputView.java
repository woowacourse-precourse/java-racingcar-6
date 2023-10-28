package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";

    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public List<String> inputCarNames() {
        String userInput = Console.readLine();
        return Arrays.asList(userInput.split(SEPARATOR));
    }

    public int inputNumberOfGameAttempts() {
        String userInput = Console.readLine();
        validateUserInputIsNumber(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateUserInputIsNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }
}
