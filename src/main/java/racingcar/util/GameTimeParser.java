package racingcar.util;

public class GameTimeParser {
    private static final char LEFT_BOUND = '0';
    private static final char LEFT_FIRST_BOUND = '1';
    private static final char RIGHT_BOUND = '9';

    public static int parse(String userGameTimeInput) {
        isNumberSequence(userGameTimeInput);
        return Integer.parseInt(userGameTimeInput);
    }

    private static void isNumberSequence(String userGameTimeInput) {
        validateNumber(userGameTimeInput.charAt(0), LEFT_FIRST_BOUND, RIGHT_BOUND);
        for (int i = 1; i < userGameTimeInput.length(); i++) {
            char currentChar = userGameTimeInput.charAt(i);
            validateNumber(currentChar, LEFT_BOUND, RIGHT_BOUND);
        }
    }

    private static void validateNumber(char inputChar, char left, char right) {
        if (inputChar < left || inputChar > right) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }


}
