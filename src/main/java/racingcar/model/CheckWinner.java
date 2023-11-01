package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CheckWinner {
    
    public static List<Integer> checkWinner(List<Integer> scoreList){
        List<Integer> winnerIndex = new ArrayList<>();
        int mx = 0;

        for(int i=0;i<scoreList.size();i++){
            if(mx<scoreList.get(i)){
                mx = scoreList.get(i);
            }
        }
        for(int i=0;i<scoreList.size();i++){
            if(mx==scoreList.get(i)){
                winnerIndex.add(i);
            }
        }

        return winnerIndex;
    }
}
