package racingcar;

import java.util.regex.Pattern;

public class RacingGame {
    public static final String COMMA=",";

    private static final Pattern INTEGER=Pattern.compile("[0-9]+");

    public RacingGame(){

    }

    public String[] splitNames(String names){
        return names.split(COMMA);
    }

    public void checkAttemptCountIsInteger(String input){
        if(!INTEGER.matcher(input).matches()){
            throw new IllegalArgumentException("정수를 입력해야합니다.");
        }
    }
}
