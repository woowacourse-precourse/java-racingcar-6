package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.enums.RacingMessage;
import racingcar.view.enums.ResultMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void DisplayMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }

    public void DisplayResultMessage(ResultMessage resultMessage) {
        System.out.println(resultMessage.getValue());
    }
}
