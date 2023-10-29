package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;

public class InputView {

    public static String startInputView() {
        System.out.println(InputMessage.START_CAR_NAME_MESSAGE);
        return Console.readLine();
    }
}
