package racingcar.view;

import racingcar.constant.message.Message;

public class OutputViewImpl implements OutputView {

    @Override
    public void printExecutionResult() {
        System.out.println(Message.EXECUTION_RESULT);
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printFinalWinner(String winner) {
        System.out.printf(Message.FINAL_WINNER, winner);
    }
}
