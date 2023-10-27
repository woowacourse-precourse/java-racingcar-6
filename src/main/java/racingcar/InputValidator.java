package racingcar;

import racingcar.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private final static String spaceString = " ";
    private final static String blankString = "";
    private final static String commaString = ",";
    private final static int maxCarNameLength = 5;

    public static void validateRacingCarsName(String racingCarsName){
        if(isEmpty(racingCarsName)){
            ExceptionMessage.INPUT_NO_CAR_NAME_MESSAGE.throwException();
        }
        if(isOutOfRange(convertStringToList(racingCarsName))){
            ExceptionMessage.INPUT_WRONG_CAR_LENGTH_MESSAGE.throwException();
        }
    }

    private static boolean isEmpty(String racingCarsName) {
        return racingCarsName == null || racingCarsName.isBlank();
    }

    private static boolean isOutOfRange(List<String> racingCarsName) {
        return racingCarsName.stream().allMatch(racingCarName -> racingCarName.length()<=maxCarNameLength);
    }

    private static List<String> convertStringToList(String racingCarsName){
        return Arrays.asList(racingCarsName.replace(spaceString, blankString).split(commaString));
    }
}
