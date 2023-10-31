package racingcar.exception;

public class ArgumentRangeOutOfBoundsException extends IllegalArgumentException {
    public ArgumentRangeOutOfBoundsException() {
        super("입력 제한 범위를 초과했습니다.");
    }
}
