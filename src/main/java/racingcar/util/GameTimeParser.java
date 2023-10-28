package racingcar.util;

public class GameTimeParser {
    private static final char LEFT_BOUND = '0';
    private static final char RIGHT_BOUND = '9';

    public static int parse(String userGameTimeInput) {
        valdiateNumber(userGameTimeInput);
        return Integer.parseInt(userGameTimeInput);
    }

    private static void valdiateNumber(String userGameTimeInput) {
        for (int i = 0; i < userGameTimeInput.length(); i++) {
            char currentChar = userGameTimeInput.charAt(i);
            if (!isNumber(currentChar)) {
                throw new IllegalArgumentException("숫자만 입력가능합니다.");
            }
        }
    }

    private static boolean isNumber(char inputChar) {
        return LEFT_BOUND <= inputChar && inputChar <= RIGHT_BOUND;
    }
}
