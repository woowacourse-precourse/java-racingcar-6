package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.MoveCount;
import racingcar.utils.ErrorMessage;

public class InputView {

    private InputView() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static MoveCount inputMoveCount() {
        try {
            MoveCount moveCount = new MoveCount(Integer.parseInt(userInput()));
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
        }
    }

    public static String[] getCarNames() {
        String input = InputView.userInput();
        return input.split(",");
    }
}
