package racingcar.game.exception;

public class IllegalDuplicateException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "이름은 중복되지 말아야 합니다.";

    public IllegalDuplicateException() {
        super(DEFAULT_MESSAGE);
    }
}
