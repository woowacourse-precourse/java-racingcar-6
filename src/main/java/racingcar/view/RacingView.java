package racingcar.view;

import static racingcar.domain.RacingConfig.NAME_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.SingleRoundResult;
import racingcar.view.enums.RacingMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayRacingMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }

    public void displayResults(List<SingleRoundResult> results) {
        results.forEach(this::displaySingleRoundResult);
    }
    private void displaySingleRoundResult(SingleRoundResult singleRoundResult) {
        displayRacingMessage(RacingMessage.RACING_RESULT);
        singleRoundResult.getCarMoveHistories().forEach(System.out::println);
        System.out.println();
    }

    public void displayWinnerMessage(List<String> results) {
        String formattingName = String.join(NAME_SEPARATOR , results);
        String result = String.format(RacingMessage.RACING_WINNER.getMessage(), formattingName);
        System.out.println(result);
    }
}
