package racingcar.validator;

import java.util.List;

public class RacingCarValidator {
    private static final String RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE ="자동차 이름은 최대 5글자입니다.";



    public static boolean racingCarNameLengthValidator(List<String> raingCar){
        if(raingCar.stream().anyMatch(v-> v.length()> 5)){
            throw new IllegalArgumentException(RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE) ;
        }
        return true;
    }
}
