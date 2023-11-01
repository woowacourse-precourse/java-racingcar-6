package racingcar.exception;

public class InputException {
    public static final String EMPTY_EXCEPTION_MESSAGE = "빈 값이 입력 되었습니다.";
    public static final String OUT_OF_NAME_EXCEPTION_MESSAGE = "5자 이상의 이름이 입력 되었습니다.";
    public static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "범위에 벗어난 값이 입력 되었습니다.";
    public static final String EXIST_NAME_EXCEPTION_MESSAGE = "중복되는 이름이 포함되어 있습니다.";
    public static final String NOT_EXIST_NAME_EXCEPTION_MESSAGE = "업데이트 하려는 이름이 없습니다.";

    public static void emptyException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }
    }

    public static void outOfNameLengthException(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(OUT_OF_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static void outOfRangeException(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    public static void existsNameException() {
        throw new IllegalArgumentException(EXIST_NAME_EXCEPTION_MESSAGE);
    }

    public static void notExistsNameException() {
        throw new IllegalArgumentException(NOT_EXIST_NAME_EXCEPTION_MESSAGE);
    }
}
