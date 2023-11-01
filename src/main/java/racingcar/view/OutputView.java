package racingcar.view;

import racingcar.dto.Result;

public interface OutputView {
    void printExecutionMessage();

    void printResult(Result result);

    void printFinalWinner(Result result);
}
