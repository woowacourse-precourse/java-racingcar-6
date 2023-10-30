package racingcar.model;


public class RacingRule {
    private final static int STANDARD_NAME_SIZE = 5;
    private final static String NAME_ERROR_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다!";
    private final static String COUNT_ERROR_MESSAGE = "올바른 시도 횟수를 입력하지 않았습니다.";

    public static boolean isOkToUseCarName(String carName) {
        if(carName.length() > STANDARD_NAME_SIZE) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean isOkToUseAttemptCount(int attemptCount) {
        try{
            int count = attemptCount;
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
        }
    }
}
