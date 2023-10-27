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
}
