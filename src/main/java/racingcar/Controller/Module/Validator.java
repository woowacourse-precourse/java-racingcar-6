package racingcar.Controller.Module;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Validator {
    public static int validateInputIsNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > 0) {
                return number;
            } else {
                throw new IllegalArgumentException("입력값은 양의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자열입니다.", e);
        }
    }


    public static ArrayList<String> validateNameInputContainsComma(String input){
        if(input.contains(",")){
            ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
            return carNames;
        }else{
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    public static Boolean validateNameLength(ArrayList<String> input){
        for(String name: input){
            if(name.length() > 5){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<String> validateNameInput(String input) {
        ArrayList<String> CarNames = validateNameInputContainsComma(input);
        if (!validateNameLength(CarNames)) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
        return CarNames;
    }
}
