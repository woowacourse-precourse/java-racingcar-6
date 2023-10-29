package racingcar.utils;

public class Validator {
    public static boolean hasValidLength(String rawString){
        String[] strings = rawString.split(",");
        for(String string: strings){
            if(string.trim().isEmpty() || string.trim().length() > 5){
                return false;
            }
        }
        return true;
    }

    public static void validateCarNames(String carNames){
        if(!hasValidLength(carNames)){
            throw new IllegalArgumentException("Car name only can be 1 to 5 characters.");
        }
    }
}
