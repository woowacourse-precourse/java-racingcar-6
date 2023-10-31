package racingcar.exception;

public class Exception extends IllegalArgumentException {

    private RacingCarError racingCarError;
    public Exception(RacingCarError racingCarError) {
        super(racingCarError.getMsg());
    }
}
