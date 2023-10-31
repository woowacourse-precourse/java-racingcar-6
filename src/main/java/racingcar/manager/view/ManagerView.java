package racingcar.manager.view;

import java.util.HashMap;
import java.util.Map;

public class ManagerView {
    private static String MOVING_CHARACTER = "-";


    public String getTotalMoveCount(int moveCount){
        return MOVING_CHARACTER.repeat(moveCount);
    }

    public void printMovingMessage(String carName, String totalMoveCount){
        System.out.print(carName + " : " + totalMoveCount);
    }
}
