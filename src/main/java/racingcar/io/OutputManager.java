package racingcar.io;

import racingcar.config.GameMessages;

public class OutputManager {
    public void printCarNameInputMessage() {
        printMessage(GameMessages.INPUT_CAR_NAME);
    }
    public void printTryCountInputMessage() {
        printMessage(GameMessages.INPUT_TRY_COUNT);
    }

    public void printExecutionResultMessage() {
        printMessage(GameMessages.EXECUTION_RESULT);
    }

    public void printFinalWinnerMessage(String winnerNames) {
        printMessage(GameMessages.FINAL_WINNER + winnerNames);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}
