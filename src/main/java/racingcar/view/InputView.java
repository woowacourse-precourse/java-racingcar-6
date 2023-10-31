package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.constant.Message;

public class InputView {
    public String getInputCarName() {
        System.out.println(Message.INPUT_CAR_NAME);
        return Console.readLine();
    }

    public String getInputCount() {
        System.out.println(Message.INPUT_MOVE_COUNT);
        return Console.readLine();
    }
}
