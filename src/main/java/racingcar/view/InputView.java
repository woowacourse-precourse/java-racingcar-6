package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;
import racingcar.validation.InputValidator;

public class InputView {

    public static String startInputView() {
        System.out.println(InputMessage.START_CAR_NAME_MESSAGE.getValue());
        return Console.readLine();
    }

    public static int roundNumberInputView() {
        System.out.println(InputMessage.TRY_COUNT_MESSAGE.getValue());
        String roundNumber = Console.readLine();
        InputValidator.validateRoundInput(roundNumber);
        return Integer.parseInt(roundNumber);
    }
}
