package racingcar.entity;

import java.util.HashMap;

public class RaceStatus {
    private static final HashMap<Racer,Integer> raceScore=new HashMap<>();

    private static Integer scoreCheckByRacer(Racer racer){
        return raceScore.getOrDefault(racer,0);
    }

    public static Integer scoreWriteByRacer(Racer racer, RoundResult roundResult){
        System.out.println("RoundScore="+roundResult.getScore());
        return raceScore.put(racer,scoreCheckByRacer(racer)+roundResult.getScore());
    }
}
