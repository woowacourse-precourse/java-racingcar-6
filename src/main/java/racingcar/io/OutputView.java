package racingcar.io;

import racingcar.constants.GameResultElement;
import racingcar.constants.ProgressMessage;

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

    public void printExecutionResultMessage(){
        System.out.println(GameResultElement.ENTER.toString() + ProgressMessage.EXECUTION_RESULT);
    }
}
