package racingcar.entity;

import racingcar.property.ResultProperty;

import static racingcar.property.ResultProperty.*;

public class RoundResult {
    private static final StringBuilder resultOfRound =new StringBuilder();

    public static void writeRoundResult(Racer racer){
        resultOfRound.append(racer.getName()).append(" : ");
        writeRoundResultScore(racer);
        writeLineBreak();
    }
    private static void writeRoundResultScore(Racer racer){
        resultOfRound.append(SCORE.repeat(Math.max(0, RaceStatus.scoreCheckByRacer(racer))));
    }

    public static void writeLineBreak(){
        resultOfRound.append("\n");
    }

    public static String getResultOfRound(){
        return resultOfRound.toString();
    }
}
