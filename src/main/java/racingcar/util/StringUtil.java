package racingcar.util;

public class StringUtil {
    private static final int CAR_MIN_LENGTH = 1;
    private static final int CAR_MAX_LENGTH = 5;
    private static final String DISTANCE_SIGN = "-";


    public static void checkCarLength(String name) {
        if (name.length() < CAR_MIN_LENGTH || name.length() > CAR_MAX_LENGTH) {
            throw new IllegalArgumentException("입력된 문자열이 1~5자가 아닙니다.");
        }
    }


}
