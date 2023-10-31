package racingcar.domain;

import java.util.HashMap;

public class Game {
    HashMap<String, String> raceResult;
    public Game(){

    }

    public void setRaceResult(HashMap raceResult){
        this.raceResult = raceResult;
    }

    public HashMap<String, String> getRaceResult(){
        return raceResult;
    }
}
