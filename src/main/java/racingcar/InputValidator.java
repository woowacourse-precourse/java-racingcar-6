package racingcar;

import java.util.Arrays;

public class InputValidator {

    private static final int nameLength = 5;

    public static void checkNameLength(String[] names){
        if (Arrays.stream(names).anyMatch(name -> name.length() > nameLength)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하입니다.");
        }
    }

    public static void checkNameNull(String[] names){
        if(Arrays.stream(names).anyMatch(name -> name.trim().isEmpty())){
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public static void checkRoundNumber(String gameRound){
        try{
            Integer.parseInt(gameRound);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("1 이상의 자연수만 입력 가능합니다.");
        }
    }

    public static void checkNotNegative(int gameRound){
        if (gameRound < 1){
            throw new IllegalArgumentException("1 보다 커야 합니다.");
        }
    }

    public static String[] splitCarName(String name){
        return name.endsWith(",") ? name.split(",", -1) : name.split(",");
    }


}
