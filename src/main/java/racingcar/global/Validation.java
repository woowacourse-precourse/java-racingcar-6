package racingcar.global;

public class Validation {

    public static String NUM_REGEX = "[0-9]+";

    public static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateRound(String round) {
        if (!round.matches(NUM_REGEX)) {
            throw new IllegalArgumentException("0이상의 숫자만 입력 가능합니다.");
        }
    }
}
