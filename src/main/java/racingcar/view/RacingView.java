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

    public void displayWinnerMessage(List<String> results) {
        String formattingName = String.join(", ", results);
        String result = String.format(ResultMessage.RACING_WINNER.getValue(), formattingName);
        System.out.println(result);
    }
}
