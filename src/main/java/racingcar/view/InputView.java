package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputMessage;

public class InputView {

    public String insertCarName() {
        System.out.println(InputMessage.INSERT_NAME.getMessage());
        return Console.readLine();
    }

    public String insertTryTimes() {
        System.out.println(InputMessage.INSERT_TRY_TIMES.getMessage());
        return Console.readLine();
    }

}
