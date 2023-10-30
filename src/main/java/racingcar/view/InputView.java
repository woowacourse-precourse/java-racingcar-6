package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_EMPTY_NAME = "올바르지 않은 입력입니다.";
    private static final String ERROR_NON_DIGIT_NUMBER = "숫자만 입력 가능합니다.";


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
        List<String> carNames = Arrays.asList(userInput.split(SEPARATOR));
        validateEmptyCarNames(carNames);
        return carNames;
    }

    public int inputNumberOfGameAttempts() {
        String userInput = Console.readLine();
        validateUserInputIsNumber(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateEmptyCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_EMPTY_NAME);
        }
    }

    private void validateUserInputIsNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_NON_DIGIT_NUMBER);
        }
    }
}
