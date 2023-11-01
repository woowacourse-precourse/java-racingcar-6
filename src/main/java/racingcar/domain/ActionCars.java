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
}
