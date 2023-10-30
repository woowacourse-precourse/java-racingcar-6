package racingcar.utils;

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
            throw new IllegalArgumentException("Car name only can be 1 to 5 characters.");
        }
    }

    public static void validateNumberOfMoves(String numberOfMoves){
        if(numberOfMoves.trim().isEmpty()){
            throw new IllegalArgumentException("Number of moves can't be empty.");
        }
        if(!isInteger(numberOfMoves)){
            throw new IllegalArgumentException("Number of moves only can be integer.");
        }
    }
}
