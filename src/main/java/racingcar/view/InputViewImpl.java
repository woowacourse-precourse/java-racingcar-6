package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.message.Message;

public class InputViewImpl implements InputView {

    public String readCars() {
        System.out.println(Message.ENTER_CARS);
        return readLine();
    }

    public String readRound() {
        System.out.println(Message.ENTER_ROUND);
        return readLine();
    }

    protected String readLine() {
        return Console.readLine();
    }
}
