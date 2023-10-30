package racingcar.util;

public class RacingCarGameUtil {
    public static final int RACING_CAR_NAME_LENGTH = 5;
    private RacingCarGameUtil() {
    };

    public static boolean validNameLength(String name) {
        if (name.length() <= RACING_CAR_NAME_LENGTH) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }

    public static boolean validNameType(Object name) {
        if (name instanceof String) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 입력 값 입니다.");
    }
}
