package racingcar.exception;

public class InputRoundException {
    private static final String NOT_INTEGER_EXCEPTION = "입력한 횟수의 값은 정수여야합니다.";
    public static int notIntegerException(String roundString) {
        try {
            int roundInt = Integer.parseInt(roundString);

            return roundInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION + " round : " + roundString);
        }
    }
}