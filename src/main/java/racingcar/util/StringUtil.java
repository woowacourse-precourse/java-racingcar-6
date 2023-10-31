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

    public static void checkNumber(String number) {
        if (!number.matches("\\d") || Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("입력된 문자열이 숫자가 아닙니다.");
        }
    }

    public static String repeatString(int cnt) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < cnt; i++) {
            sb.append(DISTANCE_SIGN);
        }
        return sb.toString();
    }

}
