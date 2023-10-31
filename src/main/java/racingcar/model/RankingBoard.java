package racingcar.model;

import java.util.*;

public class RankingBoard {
    private List<Participant> rankingBoard;

    public RankingBoard(String[] carNames){
        init(carNames);
    }

    private void init(String[] carNames){
        rankingBoard = new LinkedList<>();
        for(String carName : carNames){
            rankingBoard.add(new Participant(carName, 0));
        }
    }

    public List<Participant> getRankingBoard(){
        return rankingBoard;
    }

    public void plus(String carName){
        for(Participant participant : rankingBoard){
            if(participant.getName().equals(carName)){
                participant.plus();
            }
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxValue = findMaxValue();
        for (Participant participant : rankingBoard) {
            if(participant.getStepOfForward() == maxValue){
                winners.add(participant.getName());
            }
        }
        return winners;
    }

    private int findMaxValue(){
        int maxValue = -1;
        for(Participant participant : rankingBoard){
            maxValue = Math.max(maxValue, participant.getStepOfForward());
        }
        return maxValue;
    }
}
