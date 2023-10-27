package racingcar.utils;

import java.util.List;

public class InputValidator {
    private static int CAR_NAME_LENGTH = 5;
    private static String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 0자 이상 5자 이하만 가능합니다.";

    private static void validateCarNameLength(String carName){
        if(carName.length() > CAR_NAME_LENGTH || carName.trim().isEmpty()){
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateCarNames(List<String> carNames){
        for(String carName : carNames){
            validateCarNameLength(carName);
        }
    }

}
