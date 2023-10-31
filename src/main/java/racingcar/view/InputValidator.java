package racingcar.view;

import racingcar.config.RacingGameConfig;

public class InputValidator {
    private final String numberRegex = "^[0|/-?[1-9]\\d]*$";

    public void validateRacingCarNameLength(String[] racingCarNames){
        for(String racingCarName : racingCarNames){
            if(isBiggerMaxLength(racingCarName)){
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.getErrorMessage());
            }
        }
    }

    public void validateNumberTypeOfTry(String input){
        if(isNotNumber(input)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_TRY_TYPE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public void validateNumberRangeOfTry(int input){
        if(isSmallerMinValue(input)){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_TRY_RANGE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private boolean isSmallerMinValue(int input){
        return input < RacingGameConfig.NUMBER_OF_TRY_MIN_VALUE.getValue();
    }

    private boolean isNotNumber(String input){
        return !input.matches(numberRegex);
    }

    private boolean isBiggerMaxLength(String racingCarName){
        return racingCarName.length() > RacingGameConfig.CAR_NAME_MAX_LENGTH.getValue();
    }
}
