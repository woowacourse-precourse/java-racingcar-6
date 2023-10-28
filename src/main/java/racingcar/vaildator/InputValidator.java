package racingcar.vaildator;

import racingcar.Constant;
import racingcar.view.InputView;

import java.util.List;

public class InputValidator {

    public static boolean isBlankInput(String input){
        return removeTrimString(input).isBlank();
    }

    public static boolean isValidLengthCarNames(List<String> carNames){

        for(String carName : carNames){
            if(!isValidLengthCarName(carName.trim())) {
                throw new IllegalArgumentException(Constant.EXCEPTION_MESSAGE);
            }
        }

        return true;
    }

    private static String removeTrimString(String input){
        return input.trim();
    }

    private static boolean isValidLengthCarName(String name){
        return name.length() > 0 && name.length() <= 5;
    }

}
