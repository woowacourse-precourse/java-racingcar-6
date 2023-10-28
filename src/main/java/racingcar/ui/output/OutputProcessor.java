package racingcar.ui.output;

import racingcar.ui.Message;

public class OutputProcessor {
    public void printInput(String input) {
        System.out.println(input);
    }

    public void printStartMessageCarNames() {
        System.out.println(Message.START_MESSAGE_CAR_NAMES);
    }

    public void printStartMessageTryCount() {
        System.out.println(Message.START_MESSAGE_TRY_COUNT);
    }

    public void printResult() {
        System.out.println(Message.RESULT);
    }

    public void printResult(String carName, int forwardNumber) {
        System.out.println(carName + " : " + "-".repeat(forwardNumber));
    }

    public void printFinalWinner(String carNames) {
        System.out.println(Message.FINAL_WINNER + carNames);
    }

}
