package racingcar;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NUM_ROUND = 1;

    public static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumRound(int numRound) {
        if (numRound < MIN_NUM_ROUND) {
            throw new IllegalArgumentException();
        }
    }

}
