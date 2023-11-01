package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        System.out.println(GameMessage.START_GUIDE.getMessage());
        return Console.readLine();
    }

    public String getAttemptStr() {
        System.out.println(GameMessage.LOOP_COUNT_QUESTION.getMessage());
        return Console.readLine();
    }
}
