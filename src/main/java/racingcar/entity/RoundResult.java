package racingcar.entity;

public class RoundResult {
    private static final StringBuilder resultOfRound =new StringBuilder();

    public static void writeRoundResult(RoundScore roundScore,Racer racer){
        resultOfRound.append(racer.getName()).append(" : ").append(writeRoundResultScore(roundScore));
        writeLineBreak();
    }
    private static String writeRoundResultScore(RoundScore roundScore){
        if (roundScore == RoundScore.FORWARD){
            return "-";
        }
        return "";
    }

    public static void writeLineBreak(){
        resultOfRound.append("\n");
    }

    public static StringBuilder getResultOfRound(){
        return resultOfRound;
    }
}
