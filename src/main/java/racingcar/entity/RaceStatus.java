package racingcar.entity;

import java.util.HashMap;

public class RaceStatus {
    private static final HashMap<Racer,Integer> raceScore=new HashMap<>();

    public static Integer scoreCheckByRacer(Racer racer){
        return raceScore.getOrDefault(racer,0);
    }

    public static Integer scoreWriteByRacer(Racer racer, RoundScore roundScore){
        return raceScore.put(racer,scoreCheckByRacer(racer)+roundScore.getScore());
    }
}
