package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.GameMessage;

public class InputView {
    public static String inputCarNames() {
        String message = GameMessage.INSTRUCTIONS_ENTERING_CAR_NAME.getMessage();
        System.out.println(message);
        return Console.readLine();
    }
}
