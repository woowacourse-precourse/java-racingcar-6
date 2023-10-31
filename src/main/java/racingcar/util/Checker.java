package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

import static racingcar.resource.ConsoleRes.*;

public class Checker {
    public static void isValidInput(String input){
        isFirstWordValid(input);
        isLastWordValid(input);
    }
    public static void isFirstWordValid(String input){
        if(input.charAt(0) == ','){
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }
    public static void isLastWordValid(String input){
        if(input.charAt(input.length() - 1) == ','){
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }
    public static void isValidName(String name) {
        isBelowFiveWord(name);
        isNull(name);
    }
    static void isNull(String name){
        if(Objects.equals(name, "")){
            throw new IllegalArgumentException(EMPTY_NAME);
        }
    }
    static void isBelowFiveWord(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException(NAME_OVER_FIVE);
        }
    }

    public static boolean isStraight(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }
}
