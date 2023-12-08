package racingcar.view;

import static racingcar.type.message.MessageType.ENTER_RACE_RESULT;
import static racingcar.type.message.MessageType.FINAL_WINNER;

public class OutputViewImpl implements OutputView {
//    private static final String ENTER_RACE_RESULT = "\n실행 결과";
    @Override
    public void printExecutionResult() {
        System.out.println(ENTER_RACE_RESULT);
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printFinalWinner(String winner) {
        System.out.printf(FINAL_WINNER.getMessageValue(), winner);
    }
}
