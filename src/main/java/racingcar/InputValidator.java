package racingcar;

import java.util.Arrays;
import racingcar.constant.ExceptionMessage;

public class InputValidator {

    public static void validateCarsName(String[] names){
        validateEachName(names);
        validateDuplication(names);
    }

    private static void validateDuplication(String[] names) {
        int distinctNum = (int) Arrays.stream(names)
                .distinct()
                .count();

        if(distinctNum != names.length){
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
    }

    private static void validateEachName(String[] names) {
        for(String name : names){
            if(name.isBlank()){
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
            }
            if(name.length() > 5){
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_TOO_LONG);
            }
        }
    }

    public static void validateRoundNumber(String roundNumberString){
        int roundNumber;
        try{
            roundNumber = Integer.parseInt(roundNumberString);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_BE_NUMBER);
        }

        if(roundNumber <= 0){
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
        }
    }
}
