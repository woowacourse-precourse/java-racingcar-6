package racingcar.ui.output;

import racingcar.ui.Message;

public class OutputProcessor {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStartMessageCarNames() {
        System.out.println(Message.START_MESSAGE_CAR_NAMES.getMessage());
    }

    public void printStartMessageTryCount() {
        System.out.println(Message.START_MESSAGE_TRY_COUNT.getMessage());
    }

    public void printResult() {
        System.out.println(Message.RESULT.getMessage());
    }

    public void printResult(String carName, int forwardNumber) {
        System.out.println(carName + " : " + "-".repeat(forwardNumber));
    }

    public void printFinalWinner(String carNames) {
        System.out.println(Message.FINAL_WINNER.getMessage() + carNames);
    }

}
