package racingcar.domain;

import java.util.List;
import java.util.Map;

public class SystemOutput {
    public void printMoveResult(MoveContainer moveContainer) {
        for (Map.Entry<String, Integer> entrySet : moveContainer.getNumMoveMap().entrySet()) {
            System.out.print(entrySet.getKey() + " : ");
            for (int i = 0; i < entrySet.getValue(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printOverallResult(WinnerList winnerList){
        List<String> winList = winnerList.getWinnerNames();
        String prizeWinner = String.join(",", winList);
        System.out.println(Constants.FINAL_WINNER_MESSAGE + prizeWinner);
    }
}

