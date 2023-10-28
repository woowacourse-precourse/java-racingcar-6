package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.view.enums.RacingMessage;
import racingcar.view.enums.ResultMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }

    public void displayResultMessage(ResultMessage resultMessage) {
        System.out.println(resultMessage.getValue());
    }
}
