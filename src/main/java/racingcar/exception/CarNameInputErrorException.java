package racingcar.exception;

public class CarNameInputErrorException implements InputErrorException{
    private final static int CAR_NAME_LEGTH_MIN_RANGE = 1;
    private final static int CAR_NAME_LEGTH_MAX_RANGE = 5;
    private final static String CAR_NAME_LENGTH_SMALL_MESSAGE = "각 자동차 이름은 1글자 이상 입력해주세요.";

    @Override
    public void checkUserInputValidate(String checkString) {
        if (isCarNameSmallerMinLength(checkString)){
            throw new IllegalArgumentException(CAR_NAME_LENGTH_SMALL_MESSAGE);
        }
    }

    private static boolean isCarNameSmallerMinLength(String checkString){
        return checkString.length() < CAR_NAME_LEGTH_MIN_RANGE;
    }
}
