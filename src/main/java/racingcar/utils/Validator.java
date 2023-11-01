package racingcar.utils;

import racingcar.constants.Message;

public class Validator {
    private static boolean hasValidLength(String rawString){
        String[] strings = rawString.split(",");
        for(String string: strings){
            if(string.trim().isEmpty() || string.trim().length() > 5){
                return false;
            }
        }
        return true;
    }

    private static boolean isInteger(String rawString){
        try{
            Integer.parseInt(rawString);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void validateCarNames(String carNames){
        if(!hasValidLength(carNames)){
            throw new IllegalArgumentException(Message.ERROR_INVALID_CAR_NAME);
        }
    }

    public static void validateNumberOfMoves(String numberOfMoves){
        if(!isInteger(numberOfMoves)){
            throw new IllegalArgumentException(Message.ERROR_NOT_INTEGER);
        }
        if(Integer.parseInt(numberOfMoves) < 1){
            throw new IllegalArgumentException(Message.ERROR_INVALID_INTEGER);
        }
    }
}
