package utils;

public class NumberValidator {

    private static final int NON_RACE_VALUE = 0;
    private static final String RACE_VALUE_NOT_NUMBER_MESSAGE = "[ERROR] 레이스 시도할 회수는 숫자 여야 합니다.";
    private static final String VALUE_OVER_ZERO_MESSAGE ="[ERROR] 게임 시도 회수는 0 보다 커야 합니다.";

    public static void checkNumber(String input) {
        try{
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_VALUE_NOT_NUMBER_MESSAGE);
        }
    }

    public static void checkNumberOverZero(int input) {
        if (input <= NON_RACE_VALUE) {
            throw new IllegalArgumentException(VALUE_OVER_ZERO_MESSAGE);
        }
    }
}
