package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.messages.Messages;

public class InputView {
    public String getCarNames() {
        System.out.println(Messages.GET_CAR_NAME_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String getTryCount() {
        System.out.println(Messages.GET_TRY_COUNT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
