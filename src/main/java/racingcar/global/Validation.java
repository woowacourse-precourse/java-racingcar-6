package racingcar.global;

public class Validation {

    public static final int MIN_NAME_RANGE = 5;
    public static String NUM_REGEX = "[0-9]+";

    public static void validateCarName(String name) {
        if (name.length() > MIN_NAME_RANGE) {
            throw new IllegalArgumentException("이름은 " + MIN_NAME_RANGE + "자 이하만 가능합니다.");
        }
    }

    public static void validateRound(String round) {
        if (!round.matches(NUM_REGEX)) {
            throw new IllegalArgumentException("0이상의 숫자만 입력 가능합니다.");
        }
    }
}
