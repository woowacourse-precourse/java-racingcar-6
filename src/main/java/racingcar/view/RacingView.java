package racingcar.view;

import static racingcar.utils.ConvertListStringToString.convertListStringToString;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.RacingRoundResult;
import racingcar.view.enums.RacingMessage;

public class RacingView {
    public String readInput() {
        return Console.readLine();
    }

    public void displayRacingMessage(RacingMessage racingMassage) {
        System.out.println(racingMassage.getMessage());
    }
    public void displayResults(List<RacingRoundResult> results) {
        results.stream()
                .map(RacingRoundResult::getCarMoveHistories)
                .forEach(histories -> {
                    histories.forEach(System.out::println);
                    System.out.println();
                });
    }
    public void displayWinnerMessage(List<String> results) {
        String formattingName = String.join(", ", results);
        String result = String.format(RacingMessage.RACING_WINNER.getMessage(), formattingName);
        System.out.println(result);
    }
}
