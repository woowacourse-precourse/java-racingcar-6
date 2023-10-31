package racingcar.domain;


import java.util.List;
import java.util.Map;

import racingcar.domain.Constants;

public class SystemOutput {
    public void printMoveResult(Map<String, Integer> numMoveMap) {
        for (Map.Entry<String, Integer> entrySet : numMoveMap.entrySet()) {
            System.out.print(entrySet.getKey() + " : ");
            for (int i = 0; i < entrySet.getValue(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printOverallResult(List<String> winnerList){
        String prizeWinner = String.join(",", winnerList);
        System.out.println(Constants.FINAL_WINNER_MESSAGE + prizeWinner);
    }


}
