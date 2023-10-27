package racingcar.domain.exception;

public final class NoCarsException extends IllegalArgumentException {
    public static final String NO_CARS_EXCEPTION_MESSAGE = "생성할 차가 존재하지 않습니다.";

    public NoCarsException() {
        super(NO_CARS_EXCEPTION_MESSAGE);
    }
}
