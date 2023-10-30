package racingcar.util;

public class Validator {

    public static void validateCarLength(String carName){
        if(carName.length()>Constant.MAX_CAR_NAME_LENGTH)
            throw new IllegalArgumentException(Constant.EXCEPTION_CAR_NAME_LENGTH);
    }

    public static void validateIsNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException(Constant.EXCEPTION_IS_NOT_NUMBER);
        }
    }

}
