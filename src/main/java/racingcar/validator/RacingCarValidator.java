package racingcar.validator;

import java.util.List;

public class RacingCarValidator {
    private static final String RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE ="자동차 이름은 최대 5글자입니다.";

    private static final String ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";


    public static boolean racingCarNameLengthValidator(List<String> raingCar){
        if(raingCar.stream().anyMatch(v-> v.length()> 5)){
            throw new IllegalArgumentException(RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE) ;
        }
        return true;
    }

    public static void attemptOnlyInputNumber(String number){
        try{
            Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
