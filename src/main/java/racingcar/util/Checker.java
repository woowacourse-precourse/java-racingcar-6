package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Checker {
    public static void validateInput(String input) {
        isValidInput(input);
    }
    public static void validateCarName(String name) {
        isBelowFiveWord(name);
        isNull(name);
    }

    public static void isValidInput(String input){
        if(input.charAt(0) == ','){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if(input.charAt(input.length() - 1) == ','){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    static void isNull(String name){
        if(Objects.equals(name, "")){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }
    static void isBelowFiveWord(String name) {
        if (5 < name.length()){
            throw new IllegalArgumentException("자동차의 이름이 5글자 이상입니다.");
        }
    }

    public static boolean isStraight(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }
}
