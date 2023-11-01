package racingcar.view;

import racingcar.constant.OutputMessage;

public class Output {

    public void printExecutionResult(int index,String executionResult){
        if(index == 0)
            System.out.println("\n"+ OutputMessage.EXECUTION_RESULT.getMessage());
        System.out.println(executionResult);
    }

    public void printFinalWinner(String winners){
        System.out.println(OutputMessage.FINAL_WINNER.getMessage() + OutputMessage.COLON.getMessage() + winners);
    }
}
