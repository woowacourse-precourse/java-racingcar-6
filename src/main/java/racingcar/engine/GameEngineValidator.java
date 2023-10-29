package racingcar.engine;

public class GameEngineValidator {
    private static final String NULL_EXCEPTION_MESSAGE = "입력값은 null입니다.";

    void validateIsNotNull(String readLine) {
        if (readLine == null)
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
    }
}
