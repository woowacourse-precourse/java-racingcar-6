package racingcar.model;


public class GameRule {
    private final static int STANDARD_NAME_SIZE = 5;

    public static boolean isOkToUseCarName(String carName) {
        if(carName.length() > STANDARD_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다!");
        }
        return true;
    }

    public static boolean isOkToUseAttemptCount(int attemptCount) {
        try{
            int count = attemptCount;
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력하지 않았습니다.");
        }
    }
}
