package racingcar.view;

import static racingcar.enumType.message.InputMessage.GET_TRY_COUNT_MESSAGE;
import static racingcar.enumType.message.InputMessage.SAVE_CAR_NAMES_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readConsole() {
        System.out.println(SAVE_CAR_NAMES_MESSAGE.getValue());
        return Console.readLine();
    }

    public String readConsoleRace() {
        System.out.println(GET_TRY_COUNT_MESSAGE.getValue());
        return Console.readLine();
    }
}
