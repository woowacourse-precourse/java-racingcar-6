package racingcar.view;

import static constant.MessgeList.EXECUTION_RESULT_MESSAGE;
import static constant.MessgeList.WINNER_MESSAGE;

public class OutputView {
    public void printExecutionResultMessage(){
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }
    public void printExecutionResult(String carName, int movingForwardNumber){
        System.out.print(carName+" : ");
        for (int i = 0; i < movingForwardNumber; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void printSoleWinner(String winner){
        System.out.println(WINNER_MESSAGE+winner);
    }
}
