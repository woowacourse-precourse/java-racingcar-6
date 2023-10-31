package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Message;

public class InputView {
    public String insertCarName() {
        System.out.println(Message.INSERT_CAR_NAME);
        return Console.readLine();
    }

    public String insertTrialCount() {
        System.out.println(Message.ASK_TRY_COUNT);
        return Console.readLine();
    }
}
