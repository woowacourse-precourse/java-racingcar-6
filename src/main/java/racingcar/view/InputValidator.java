package racingcar.view;

import racingcar.config.RacingGameConfig;

public class InputValidator {
    public void validateRacingCarName(String[] racingCarNames){
        for(String racingCarName : racingCarNames){
            if(isBiggerMaxLength(racingCarName)){
                throw new IllegalArgumentException("car name size must be smaller than 6.");
            }
        }
    }

    public void validateNumberTypeOfTry(String input){
        if(!isNumber(input)){
            throw new IllegalArgumentException("number of try must be typed number");
        }
    }

    public void validateNumberRangeOfTry(int input){
        if(isSmallerMinValue(input)){
            throw new IllegalArgumentException("number range of try must be bigger than 0");
        }
    }

    private boolean isSmallerMinValue(int input){
        return input < RacingGameConfig.NUMBER_OF_TRY_MIN_VALUE.getValue();
    }
    private boolean isNumber(String input){
        return input.matches("[0-9]");
    }
    private boolean isBiggerMaxLength(String racingCarName){
        return racingCarName.length() > RacingGameConfig.CAR_NAME_MAX_LENGTH.getValue();
    }
}
