package racingcar.validator;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarValidator {
    private static final String RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE ="자동차 이름은 최대 5글자입니다.";
    private static final String RACING_CAR_NAME_EMPTY_EXCEPTION_MESSAGE= "문자를 입력해주세요.";

    private static final String ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String ATTEMPT_NUMBER_INPUT_EMPTY_EXCEPTION_MESSAGE = "숫자를 입력해주세요";



    public static boolean racingCarNameLengthValidator(List<RacingCar> raingCar){
        if(raingCar.stream().anyMatch(v-> v.getName().length()> 5)){
            throw new IllegalArgumentException(RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE) ;
        }
        return true;
    }

    public static void attemptInputOnlyNumberValidator(String number){
        try{
            Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static boolean racingCarNameEmptyInputValidator(String racingCars){
        if(racingCars.length()==0){
            throw new IllegalArgumentException(RACING_CAR_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean attemptNumberEmptyInputValidator(String number){
        if(number.length()==0){
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }


}
