package racingcar;

public class ApplicationException extends IllegalArgumentException {
    private static final String EXCEPTION_NAME = "이름은 5자 이하만 가능합니다.";

    public ApplicationException() {
        super(EXCEPTION_NAME);
    }
}
