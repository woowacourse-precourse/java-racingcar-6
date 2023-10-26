package racingcar.exception;

public class CarNameInputErrorException implements InputErrorException{
    private final static int CAR_NAME_LEGTH_MIN_RANGE = 1;
    private final static int CAR_NAME_LEGTH_MAX_RANGE = 5;
    private final static String CAR_NAME_LENGTH_SHORT_MESSAGE = "각 자동차 이름은 1글자 이상 입력해주세요.";
    private final static String CAR_NAME_LENGTH_LONG_MESSAGE = "각 자동차 이름은 1글자 이상 입력해주세요.";

    @Override
    public void checkUserInputValidate(String checkString) {
        if (isCarNameShorterThanMinLength(checkString)){
            throw new IllegalArgumentException(CAR_NAME_LENGTH_SHORT_MESSAGE);
        } else if (isCarNameLongerThanMaxLength(checkString)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LONG_MESSAGE);
        }
    }

    private static boolean isCarNameShorterThanMinLength(String checkString){
        return checkString.length() < CAR_NAME_LEGTH_MIN_RANGE;
    }

    private static boolean isCarNameLongerThanMaxLength(String checkString){
        return checkString.length() > CAR_NAME_LEGTH_MAX_RANGE;
    }
}
