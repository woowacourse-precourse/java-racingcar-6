package racingcar;

import java.util.HashMap;

public class Error extends Throwable {
    final public static int INVALID_NAME_LENGTH = 1;

    final static HashMap<Integer, String> errors = new HashMap<>(){{
        put(INVALID_NAME_LENGTH, "이름의 길이는 1 이상 5 이하만 가능합니다.");
    }};

    public static void throwError(int errorCode){
        throw new IllegalArgumentException(errors.get(errorCode));
    }
}
