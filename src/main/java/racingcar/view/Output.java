package racingcar.view;

import static racingcar.constant.Constant.EXECUTION_RESULT;
import static racingcar.constant.Constant.FINAL_WINNER;
import static racingcar.constant.Constant.COLON;

public class Output {

    public void printExecutionResult(String executionResult){
        System.out.println(EXECUTION_RESULT);
        System.out.println(executionResult);
    }

    public void printFinalWinner(String winners){
        System.out.println(FINAL_WINNER + COLON + winners);
    }
}
