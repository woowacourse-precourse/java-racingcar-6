package racingcar;

public class RacingGame {
    public static final String COMMA=",";
    public RacingGame(){

    }

    public String[] splitNames(String names){
        return names.split(COMMA);
    }
}
