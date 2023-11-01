package racingcar.io.output;

import racingcar.constants.GameResultElement;
import racingcar.constants.message.ProgressMessage;

public class OutputView {

    public void printRacingCarNamesMessage() {
        System.out.println(ProgressMessage.INPUT_RACING_CAR_NAMES);
    }

    public void printAttemptCountMessage() {
        System.out.println(ProgressMessage.INPUT_ATTEMPT_COUNT);
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }

    public void printExecutionResultMessage() {
        System.out.println(GameResultElement.ENTER.toString() + ProgressMessage.EXECUTION_RESULT);
    }

    public void printFinalWinners(String finalWinners) {
        System.out.println(ProgressMessage.FINAL_WINNERS.toString() + GameResultElement.COLON + finalWinners);
    }
}
