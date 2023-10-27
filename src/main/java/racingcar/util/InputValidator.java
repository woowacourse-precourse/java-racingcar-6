package racingcar.util;

public class InputValidator {

    private static final String CAR_NAME_LONG = "자동차 이름의 길이가 5를 초과하였습니다. : ";
    private static final int MAX_LENGTH = 5;

    public static void validateRacingCarNames(String[] racingCarNames) {
        for (String racingCarName : racingCarNames) {
            if (racingCarName.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LONG+racingCarName);
            }
        }
    }

}