package racingcar.manager.view;

import java.util.HashMap;
import java.util.Map;

public class ManagerView {
    private static String MOVING_CHARACTER = "-";
    private static String EXECUTION_RESULT = "실행 결과";


    public String getTotalMoveCount(int moveCount){
        return MOVING_CHARACTER.repeat(moveCount);
    }

    public void printMovingMessage(String carName, String totalMoveCount){
        System.out.println(carName + " : " + totalMoveCount);
    }
    public void printResultMessage(){
        System.out.println(EXECUTION_RESULT);
    }
    public void printFinishOneTry(){
        System.out.println();
    }
}
