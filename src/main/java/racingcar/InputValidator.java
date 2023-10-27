package racingcar;

import racingcar.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private final static String spaceString = " ";
    private final static String blankString = "";
    private final static String commaString = ",";
    private final static int MAX_LENGTH_OF_CAR_NAME= 5;
    private final static int MIN_SIZE_OF_COUNT = 0;

    public static void validateRacingCarsName(String racingCarsName){
        if(isEmpty(racingCarsName)){
            ExceptionMessage.INPUT_NO_CAR_NAME_MESSAGE.throwException();
        }
        if(isOutOfRange(convertStringToList(racingCarsName))){
            ExceptionMessage.INPUT_WRONG_CAR_LENGTH_MESSAGE.throwException();
        }
    }

    public static void validateCount(String count){
        if(isEmpty(count)){
            ExceptionMessage.INPUT_NO_COUNT_MESSAGE.throwException();
        }
        if(!isNumber(count)){
            ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.throwException();
        }
        if(!isOverZero(count)){
            ExceptionMessage.INPUT_WRONG_RANGE_OF_COUNT_MESSAGE.throwException();
        }
    }

    private static boolean isEmpty(String inputString) {
        return inputString == null || inputString.isBlank();
    }

    private static boolean isOutOfRange(List<String> racingCarsName) {
        return racingCarsName.stream().allMatch(racingCarName -> racingCarName.length()<=MAX_LENGTH_OF_CAR_NAME);
    }

    private static boolean isNumber(String count) {
        return count.chars().allMatch(Character::isDigit);
    }

    private static boolean isOverZero(String count) {
        return Integer.parseInt(count)>MIN_SIZE_OF_COUNT;
    }

    private static List<String> convertStringToList(String racingCarsName){
        return Arrays.asList(racingCarsName.replace(spaceString, blankString).split(commaString));
    }
}
