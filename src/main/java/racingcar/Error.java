package racingcar;

import java.util.HashMap;

public class Error extends Throwable {
    final public static int INVALID_NAME_LENGTH = 1;
    final public static int DUPLICATE_NAME = 2;
    final public static int INVALID_ATTEMPT_INPUT = 10;

    final static HashMap<Integer, String> errors = new HashMap<>(){{
        put(INVALID_NAME_LENGTH, "이름의 길이는 1 이상 5 이하만 가능합니다.");
        put(DUPLICATE_NAME, "중복된 이름은 입력 불가능합니다.");
        put(INVALID_ATTEMPT_INPUT, "숫자만 입력 가능합니다.");
    }};

    public static void throwError(int errorCode){
        throw new IllegalArgumentException(errors.get(errorCode));
    }
}
