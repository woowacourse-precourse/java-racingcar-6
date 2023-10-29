package racingcar.exceptions.runtime;

public class NotFoundSourceException extends RuntimeException {

    private static final String NOT_FOUND_SOURCE_MESSAGE = "해당하는 값이 존재하지 않습니다.";

    public NotFoundSourceException() {
        super(NOT_FOUND_SOURCE_MESSAGE);
    }
}
