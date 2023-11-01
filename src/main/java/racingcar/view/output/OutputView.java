package racingcar.view.output;

import static racingcar.constant.Constant.COMMA_AND_BLANK;
import static racingcar.constant.Constant.EXECUTION_RESULT_MENT;
import static racingcar.constant.Constant.FINAL_WINNER;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void printExecutionResultMent() {
        System.out.println(EXECUTION_RESULT_MENT);
    }

    public void printExecutionResult(String executionResult) {
        System.out.println(executionResult);
    }

    public void printWinners(List<String> winnerNames) {
        System.out.println(FINAL_WINNER + findWinners(winnerNames));
    }

    private String findWinners(List<String> winnerNames) {
        StringJoiner finalWinners = new StringJoiner(COMMA_AND_BLANK);
        winnerNames.forEach(finalWinners::add);
        return finalWinners.toString();
    }
}
