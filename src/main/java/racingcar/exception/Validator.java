package racingcar.exception;

public class Validator {
    final static int STANDARD_NUMBER = 5;
    final static String INTEGER_REGEX = "^[0-9]*$";
    final static String ERROR_EMPTY = "잘못된 입력 [입력값이 비어있습니다.]";
    final static String ERROR_OVER = "잘못된 입력 [5자 이하의 값을 입력해주세요.]";
    final static String ERROR_NOT_INTEGER = "잘못된 입력 [입력값이 숫자형태가 아닙니다.]";

    public static void empty(String data) {
        if(data.isEmpty()){
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }

    public static void fiveOrLess(String data) {
        if(data.length() > STANDARD_NUMBER) {
            throw new IllegalArgumentException(ERROR_OVER);
        }
    }

    public static void integer(String data) {
        if(!data.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }
}
