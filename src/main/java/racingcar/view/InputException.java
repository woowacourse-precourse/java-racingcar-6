package racingcar.view;

import racingcar.constant.ExceptionMeaage;

import java.util.regex.Pattern;

public class InputException {

    public void inputSeparatorException(String carNames) throws IllegalArgumentException{
        if(!Pattern.matches("^[a-z|A-Z|ㄱ-ㅎ|가-힣|,]+$",carNames))
           throw new IllegalArgumentException(ExceptionMeaage.SEPARATOR_EXCEPTION.getMessage());
    }

    public void inputCarsSizeException(String[] carNames) throws IllegalArgumentException{
        if(carNames.length < 2){
            throw new IllegalArgumentException(ExceptionMeaage.CARS_SIZE_EXCEPTION.getMessage());
        }
    }

    public void inputCarNameOfLengthException(String[] carNames) throws IllegalArgumentException{
        for(String carName : carNames){
            if(carName.length()  > 5){
                throw new IllegalArgumentException(ExceptionMeaage.CAR_NAME_OF_LENGTH_EXCEPTION.getMessage());
            }
        }
    }

    public void inputMovingNumberException(String str){
        if(!Pattern.matches("^[1-9]+$",str))
            throw new IllegalArgumentException(ExceptionMeaage.MOVING_NUMBER_EXCEPTION.getMessage());
    }
}
