package racingcar.manager.view;

import java.util.List;

public class ManagerView {
    private static String MOVING_CHARACTER = "-";
    private static String EXECUTION_RESULT = "실행 결과";
    private static String FINAL_WINNERS = "최종 우승자 : ";
    private static String SPACE_DELIMITER = ", ";


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
    public void printFinalWinners(List<String> winnerCars){
        String finalWinners = String.join(SPACE_DELIMITER,winnerCars);
        System.out.print(FINAL_WINNERS + finalWinners);
    }
}
