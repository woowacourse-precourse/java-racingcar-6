package racingcar.utils;

public class InputValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String NOT_INTEGER_MESSAGE = "입력된 값이 정수가 아닙니다.";
    private static final String OUT_OF_LENGTH_MESSAGE = "차 이름의 길이는 " + MIN_LENGTH + "에서 " + MAX_LENGTH + "까지여야 합니다.";
    private static final String NULL_MESSAGE = "값을 입력하여 주십시오.";

    public static void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }
    public static void checkValidStringLength(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        for (String element : array) {
            if (element == null || element.length() < MIN_LENGTH || element.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(OUT_OF_LENGTH_MESSAGE);
            }
        }
    }

}
