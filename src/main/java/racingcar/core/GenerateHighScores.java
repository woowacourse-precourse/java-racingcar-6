package racingcar.core;

import racingcar.entity.Racer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateHighScores {

    private static List<Racer> racersWithHighScore;

    public GenerateHighScores(List<Racer> highScores){
        racersWithHighScore=highScores;
    }

    public String generateHighScoresByRacerList(){
        return racersWithHighScore
                                .stream()
                                .map(racer -> racer.getName())
                                .collect(Collectors.toList())
                                .toString()
                                .replaceAll("\\[|\\]", "");
    }

    public static List<Racer> getRacersWithHighScore() {
        return racersWithHighScore;
    }
}
