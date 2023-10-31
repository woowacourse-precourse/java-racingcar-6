package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinner {
    private List<String> winnerList = new ArrayList<>();
    public List<String> findWinner(HashMap<String,Integer> carList){
        int maxMove = findMaxMove(carList);
        for(Map.Entry<String, Integer> item : carList.entrySet()){
            createWinnerList(item, maxMove);
        }
        return winnerList;
    }
    private void createWinnerList(Map.Entry<String, Integer> item, int maxMove){
        if(item.getValue() == maxMove){
            winnerList.add(item.getKey());
        }
    }
    private int findMaxMove(HashMap<String,Integer> carList){
        int maxMove = 0;
        for(int carMove : carList.values()){
            maxMove = Math.max(maxMove,carMove);
        }
        return maxMove;
    }
}
