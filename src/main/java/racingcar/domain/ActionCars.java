package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RacingGame;

public class ActionCars {

    RacingGame racinggame = new RacingGame();

    public void goCar(int carNum){
        List<String> countResult = new ArrayList<String>();
        countResult = racinggame.getCountResult();
        String change = countResult.get(carNum);
        change += "-";
        countResult.set(carNum, change); 
    }

    public void resetCountResult(){
        int num = racinggame.getCarNumbers();
        List<String> countResult = new ArrayList<String>();

        for(int i = 0 ; i < num;i++){
            countResult.add("");
        }

        racinggame.setCountResult(countResult);
    }

    public int winnerGoCount(int carNumbers){
        int maxlength = 0;
        for(int i = 0 ; i < carNumbers ; i++){
            if(racinggame.getCountResult().get(i).length() > maxlength){
                maxlength = racinggame.getCountResult().get(i).length();
            }
        }
        return maxlength;
    }
}
