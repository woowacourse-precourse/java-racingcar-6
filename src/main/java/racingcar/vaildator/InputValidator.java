package racingcar.vaildator;

import racingcar.Constant;
import racingcar.view.InputView;

import java.util.List;

import static racingcar.Constant.*;

public class InputValidator {

    public static boolean isBlankInput(String input){
        return removeTrimString(input).isBlank();
    }

    //코드 리펙토링
    public static void isValidLengthCarNames(String... carNames){

        for(String carName : carNames){
            if(!isValidLengthCarName(carName.trim())) {
                throw new IllegalArgumentException(OVER_LENGTH_CAR_NAME);
            }
        }

    }

    public static boolean isNotInteger(String input) {
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                return true;
            }
        }
        return false;
    }


    public static String removeTrimString(String input){
        return input.trim();
    }

    private static boolean isValidLengthCarName(String name){
        return name.length() >= MINIMUM_NAME_LENGTH && name.length() <= MAXIMUM_NAME_LENGTH;
    }

}
