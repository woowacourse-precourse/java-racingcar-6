package racingcar.view;

import static racingcar.enumType.message.OutputMessage.RESULT_MESSAGE;
import static racingcar.enumType.message.OutputMessage.WINNER_MESSAGE;

public class OutputView {

    public void printStartRaceMessage() {
        System.out.println(RESULT_MESSAGE.getValue());
    }

    public void printRoundRaceResults(StringBuilder roundRaceResult) {
        System.out.println(roundRaceResult);
    }

    public StringBuilder initWinnerResult() {
        StringBuilder winner = new StringBuilder();
        winner.append(WINNER_MESSAGE.getValue()).append(" : ");
        return winner;
    }

    public void printWinnerResult(StringBuilder winnerResult) {
        System.out.println(winnerResult);
    }
}
