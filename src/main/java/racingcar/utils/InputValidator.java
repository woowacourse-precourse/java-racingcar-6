package racingcar.utils;

public class InputValidator {
    private static int CAR_NAME_LENGTH = 5;
    private static String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    public static void validateCarNameLength(String carName){
        if(carName.length() > CAR_NAME_LENGTH){
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

}
