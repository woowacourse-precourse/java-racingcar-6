package racingcar.view;

import racingcar.constant.message.Message;
import racingcar.dto.Result;

public class OutputViewImpl implements OutputView {

    @Override
    public void printExecutionMessage() {
        System.out.println(Message.EXECUTION_RESULT);
    }

    @Override
    public void printResult(Result result) {
        System.out.println(result.toIntermediateResult());
    }

    @Override
    public void printFinalWinner(Result result) {
        System.out.print(result.toFinalWinner());
    }
}
