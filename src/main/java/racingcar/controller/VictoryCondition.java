package racingcar.controller;

import racingcar.model.RacingData;

import java.util.ArrayList;
import java.util.List;

public class VictoryCondition {

    RacingData racingData = RacingData.getInstance();


    public int mostFarDistance (List<Integer> forwardPointList){

        int mostFar =0;

        for (int i = 0; i < forwardPointList.size(); i++) {

            if(forwardPointList.get(i) >= mostFar){
                mostFar = forwardPointList.get(i);
            }
        }
        racingData.setMostFar(mostFar);
        return mostFar;
    }


    public int winnerNumber(){
        int winners = 0;

        for (int i = 0; i < racingData.getForwardPointList().size(); i++) {

            if (racingData.getForwardPointList().get(i) == racingData.getMostFar()) {
                winners++;
            }
        }

        return winners;
    }


    public List<String> makeWinnerList(List<String> carList, List<Integer> updatePointList,int mostFar) {

        List<String> winner = new ArrayList<>();

        for (int i = 0; i < carList.size(); i++) {
            if(updatePointList.get(i) == mostFar){
                winner.add(carList.get(i));
            }
        }
        return winner;
    }


}
