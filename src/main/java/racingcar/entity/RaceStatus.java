package racingcar.entity;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RaceStatus {
    private static final HashMap<Racer,Integer> raceScore=new HashMap<>();

    public static Integer scoreCheckByRacer(Racer racer){
        return raceScore.getOrDefault(racer,0);
    }

    public static Integer scoreWriteByRacer(Racer racer, RoundScore roundScore){
        return raceScore.put(racer,scoreCheckByRacer(racer)+roundScore.getScore());
    }

    public static List<Racer> racersWithHighScore(){
        int maxScore = raceScore.values().stream().mapToInt(v -> v).max().orElse(0);
        return raceScore.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .map(HashMap.Entry::getKey)
                .collect(Collectors.toList());
    }
}
