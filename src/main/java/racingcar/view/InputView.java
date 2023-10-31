package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Utils.ErrorMessage;

public class InputView {

    private InputView() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static int inputMoveCount() {
        try {
            int moveCount = Integer.parseInt(userInput());
            if (moveCount < 1) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_MIN_NUMBER_ONE.getMessage());
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }

    public static String[] getCarNames() {
        String input = InputView.userInput();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_BLANK.getMessage());
            }
        }
        return carNames;
    }
}
