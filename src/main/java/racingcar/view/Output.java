package racingcar.view;

import static racingcar.constant.Constant.EXECUTION_RESULT;
import static racingcar.constant.Constant.FINAL_WINNER;
import static racingcar.constant.Constant.COLON;

public class Output {

    public void printExecutionResult(int index,String executionResult){
        if(index == 0)
            System.out.println("\n"+EXECUTION_RESULT);
        System.out.println(executionResult);
    }

    public void printFinalWinner(String winners){
        System.out.println(FINAL_WINNER + COLON + winners);
    }
}
