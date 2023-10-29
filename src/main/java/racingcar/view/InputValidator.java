package racingcar.view;

public class InputValidator {
    public void validateRacingCarName(String[] racingCarNames){
        for(String racingCarName : racingCarNames){
            if(racingCarName.length() > 5){
                throw new IllegalArgumentException("car name size must be smaller than 6.");
            }
        }
    }

    public void validateNumberTypeOfTry(String input){
        if(!input.matches("[0-9]")){
            throw new IllegalArgumentException("number of try must be typed number");
        }
    }

    public void validateNumberRangeOfTry(int input){
        if(input < 1){
            throw new IllegalArgumentException("number range of try must be bigger than 0");
        }
    }
}
