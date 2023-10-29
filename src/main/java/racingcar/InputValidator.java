package racingcar;

public class InputValidator {

    private static final int LIMIT_NAME_LEN = 5;
    private static final int MINIMUM_TRY_NUM = 1;
//    private static final String TOO_LONG_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
//    private static final String TOO_LOW_TRY_NUM_ERROR_MESSAGE = "시도 횟수는 최소 1회 이상이어야 합니다.";
//    private static final String NOT_NUMBER_ERROR_MESSAGE = "시도 횟수는 숫자만 입력해야 합니다.";
//    private static final String BLANK_NAME_ERROR_MESSAGE = "자동차 이름은 최소 한 글자 이상의 공백이 아닌 문자여야 합니다.";


    public static void validateCarsName(String[] carsName) {
        for (String carName : carsName) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(ErrorMessages.BLANK_NAME_ERROR_MESSAGE);
            }
            if (carName.length() > LIMIT_NAME_LEN)
                throw new IllegalArgumentException();
        }
    }

    public static int validateTryNum(String stringTryNum) {
        int tryNum;
        try {
            tryNum = Integer.parseInt(stringTryNum);
            if (tryNum < MINIMUM_TRY_NUM) {
                throw new IllegalArgumentException(ErrorMessages.TOO_LOW_TRY_NUM_ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_ERROR_MESSAGE);
        }
        return tryNum;
    }
}
