package racingcar.Controller.Module;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Validator {
    public int validateInputIsNumber(int input){
        if(input > 0){
            return input;
        }else{
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
    }

    public ArrayList<String> validateNameInputContainsComma(String input){
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
