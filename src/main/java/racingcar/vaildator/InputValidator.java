package racingcar.vaildator;

import racingcar.Constant;
import racingcar.view.InputView;

import java.util.List;

import static racingcar.Constant.EXCEPTION_MESSAGE;
import static racingcar.Constant.OVER_LENGTH_CAR_NAME;

public class InputValidator {

    public static boolean isBlankInput(String input){
        return removeTrimString(input).isBlank();
    }

    public static boolean isValidLengthCarNames(List<String> carNames){

        for(String carName : carNames){
            if(!isValidLengthCarName(carName.trim())) {
                throw new IllegalArgumentException(OVER_LENGTH_CAR_NAME);
            }
        }

        return true;
    }

    public static boolean isNotInteger(String input) {
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                return true;
            }
        }
        return false;
    }



    private static String removeTrimString(String input){
        return input.trim();
    }

    private static boolean isValidLengthCarName(String name){
        return name.length() > 0 && name.length() <= 5;
    }

}
