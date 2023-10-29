package racingcar.model;

import java.util.*;

public class RankingBoard {
    private Map<String, Integer> rankingBoard;

    public RankingBoard(String[] carNames){
        init(carNames);
    }

    private void init(String[] carNames){
        rankingBoard = new HashMap<>();
        for(String carName : carNames){
            rankingBoard.put(carName, 0);
        }
    }

    public Map<String, Integer> getRankingBoard(){
        return rankingBoard;
    }

    public Set<String> getCarNames(){
        return rankingBoard.keySet();
    }

    public void plus(String carName){
        rankingBoard.put(carName, rankingBoard.get(carName)+1);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxValue = Collections.max(rankingBoard.values());
        for (Map.Entry<String, Integer> entry : rankingBoard.entrySet()) {
            if(entry.getValue() == maxValue){
                winners.add(entry.getKey());
            }
        }
        return winners;
    }


}
